package com.galprom.putty;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShellExecutor {
    boolean log = true;

    public ShellExecutor(boolean log) {
        this.log = log;
    }

    public ShellExecutor() {
    }

    private static final Logger LOGGER = Logger.getLogger(ShellExecutor.class);

    public String execute(String cmdLine) throws IOException {
        if (log) LOGGER.info("execute command : " + cmdLine);
        Process p = Runtime.getRuntime().exec(cmdLine);
        BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = stdInput.readLine()) != null) {
            sb.append(line).append("\n");
            if (log) LOGGER.info("shell-log : " + line);
        }
        if (log) LOGGER.info("shell-log : END WORK");
        return sb.toString();
    }

    public void deamonExecute(String cmdLine) throws IOException {
        Runtime.getRuntime().exec(cmdLine);
        if (log) LOGGER.info("deamonExecute(" + cmdLine + ") SUCCESS");
    }
}