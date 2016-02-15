package com.buildersaccess.haustalk.model.entity;

/**
 * Created by pangg_000 on 1/20/2016.
 */
public class Req_ba_pushnotification {
    /**
     * token : String
     * tokensecret : String
     * title : String
     * message : String
     * msgcount : 0
     * validyn : String
     * email : String
     */

    private String token;
    private String tokensecret;
    private String title;
    private String message;
    private int msgcount;
    private String validyn;
    private String email;

    public void setToken(String token) {
        this.token = token;
    }

    public void setTokensecret(String tokensecret) {
        this.tokensecret = tokensecret;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setMsgcount(int msgcount) {
        this.msgcount = msgcount;
    }

    public void setValidyn(String validyn) {
        this.validyn = validyn;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public String getTokensecret() {
        return tokensecret;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public int getMsgcount() {
        return msgcount;
    }

    public String getValidyn() {
        return validyn;
    }

    public String getEmail() {
        return email;
    }
}
