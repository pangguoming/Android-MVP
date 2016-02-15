package com.buildersaccess.haustalk.model.entity;

/**
 * Created by pangg_000 on 1/26/2016.
 */
public class Forgotpassword {
    private String validtoken;
    private String found;
    private String message;
    private String emailemployee;
    private String emailhomeowner;

    public String getValidtoken() {
        return validtoken;
    }

    public void setValidtoken(String validtoken) {
        this.validtoken = validtoken;
    }

    public String getFound() {
        return found;
    }

    public void setFound(String found) {
        this.found = found;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEmailemployee() {
        return emailemployee;
    }

    public void setEmailemployee(String emailemployee) {
        this.emailemployee = emailemployee;
    }

    public String getEmailhomeowner() {
        return emailhomeowner;
    }

    public void setEmailhomeowner(String emailhomeowner) {
        this.emailhomeowner = emailhomeowner;
    }
}
