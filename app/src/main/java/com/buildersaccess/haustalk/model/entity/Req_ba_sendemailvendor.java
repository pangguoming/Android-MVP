package com.buildersaccess.haustalk.model.entity;

/**
 * Created by pangg_000 on 1/20/2016.
 */
public class Req_ba_sendemailvendor {
    /**
     * token : String
     * tokensecret : String
     * idcia : String
     * idvendor : String
     * idwebcare1 : String
     * emailto : String
     * emailcc : String
     * subject : String
     * notes : String
     * ack : String
     * emailtoname : String
     * callflag : 0
     */

    private String token;
    private String tokensecret;
    private String idcia;
    private String idvendor;
    private String idwebcare1;
    private String emailto;
    private String emailcc;
    private String subject;
    private String notes;
    private String ack;
    private String emailtoname;
    private int callflag;

    public void setToken(String token) {
        this.token = token;
    }

    public void setTokensecret(String tokensecret) {
        this.tokensecret = tokensecret;
    }

    public void setIdcia(String idcia) {
        this.idcia = idcia;
    }

    public void setIdvendor(String idvendor) {
        this.idvendor = idvendor;
    }

    public void setIdwebcare1(String idwebcare1) {
        this.idwebcare1 = idwebcare1;
    }

    public void setEmailto(String emailto) {
        this.emailto = emailto;
    }

    public void setEmailcc(String emailcc) {
        this.emailcc = emailcc;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setAck(String ack) {
        this.ack = ack;
    }

    public void setEmailtoname(String emailtoname) {
        this.emailtoname = emailtoname;
    }

    public void setCallflag(int callflag) {
        this.callflag = callflag;
    }

    public String getToken() {
        return token;
    }

    public String getTokensecret() {
        return tokensecret;
    }

    public String getIdcia() {
        return idcia;
    }

    public String getIdvendor() {
        return idvendor;
    }

    public String getIdwebcare1() {
        return idwebcare1;
    }

    public String getEmailto() {
        return emailto;
    }

    public String getEmailcc() {
        return emailcc;
    }

    public String getSubject() {
        return subject;
    }

    public String getNotes() {
        return notes;
    }

    public String getAck() {
        return ack;
    }

    public String getEmailtoname() {
        return emailtoname;
    }

    public int getCallflag() {
        return callflag;
    }
}
