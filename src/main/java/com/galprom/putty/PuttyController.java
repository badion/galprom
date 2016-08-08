package com.galprom.putty;

import com.jcraft.jsch.*;

import java.io.*;

public class PuttyController {
    private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(PuttyController.class);

    public static void main(String[] args) throws JSchException, IOException, SftpException {
        String warName = "galprom";
        String remoteHome = copyWARToRemoteHome();
        String remoteTomcatWebAppDir = "/usr/share/tomcat7/webapps";
        execCommand(
                "sudo service tomcat7 stop\n" +
                        "cd " + remoteTomcatWebAppDir + "\n" +
                        "sudo rm -rf " + warName + "\n" +
                        "sudo rm -rf " + warName + ".war\n" +
                        "sudo cp " + remoteHome + "/" + warName + ".war " + remoteTomcatWebAppDir + "/" + warName + ".war\n" +
                        "sudo service tomcat7 start\n" +
                        "sudo service tomcat7 restart");
    }

    private static void execCommand(String command) throws JSchException, IOException {
        Session session = getSession();
        Channel channel;
        channel = session.openChannel("exec");
        ((ChannelExec) channel).setCommand(command);
        channel.setInputStream(null);
        ((ChannelExec) channel).setErrStream(System.err);
        InputStream in = channel.getInputStream();
        channel.connect();


        LOGGER.info("command : " + command);
        byte[] tmp = new byte[1024];
        while (true) {
            while (in.available() > 0) {
                int i = in.read(tmp, 0, 1024);
                if (i < 0) break;
                LOGGER.info(new String(tmp, 0, i));
            }
            if (channel.isClosed()) {
                LOGGER.info("exit-status: " + channel.getExitStatus());
                break;
            }
        }
        channel.disconnect();
        session.disconnect();
    }

    private static Session getSession() throws JSchException {
        String host = "52.26.139.136";
        String user = "ec2-user";
        JSch jsch = new JSch();
        String privateKey = "badion.ppk";
        jsch.addIdentity(privateKey);
        LOGGER.info("identity added SUCCESS");
        Session session = jsch.getSession(user, host, 22);
        LOGGER.info("session created SUCCESS");

        java.util.Properties config = new java.util.Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);

        session.connect();
        LOGGER.info("session connected SUCCESS");
        return session;
    }

    private static String copyWARToRemoteHome() throws SftpException, JSchException, IOException {
        Session session = getSession();
        Channel channel = session.openChannel("sftp");
        ChannelSftp channelSftp = (ChannelSftp) channel;
        channelSftp.connect();
        String remoteHome = channelSftp.getHome();
        channelSftp.put(new FileInputStream(new File("target/galprom.war")), remoteHome + "/galprom.war");
        channelSftp.disconnect();
        session.disconnect();
        return remoteHome;
    }
}
