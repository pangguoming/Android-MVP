package com.buildersaccess.haustalk.model.entity;

/**
 * Created by pangg_000 on 1/20/2016.
 */
public class Req_login {
    /**
     * email : String
     * password : String
     * webyn : String
     * iosyn : String
     * devicetoken : String
     */

    private String email;
    private String password;
    private String webyn;
    private String iosyn;
    private String devicetoken;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setWebyn(String webyn) {
        this.webyn = webyn;
    }

    public void setIosyn(String iosyn) {
        this.iosyn = iosyn;
    }

    public void setDevicetoken(String devicetoken) {
        this.devicetoken = devicetoken;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getWebyn() {
        return webyn;
    }

    public String getIosyn() {
        return iosyn;
    }

    public String getDevicetoken() {
        return devicetoken;
    }
}
