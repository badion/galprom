package com.galprom.mail;

/**
 * Created by Mykhaylo_Mikus on 5/22/2016.
 */
public class User {
    private String name;
    private String tel;
    private String mail;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }

    public User(String name, String tel, String mail) {
        this.name = name;
        this.tel = tel;
        this.mail = mail;
    }
}
