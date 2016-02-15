package com.buildersaccess.haustalk.model.entity;

/**
 * Created by pangg_000 on 1/20/2016.
 */
public class Req_sendemail {
    /**
     * token : String
     * tokensecret : String
     * idcia : String
     * idproject : String
     * idwebcare1 : String
     * emailto : String
     * emailcc : String
     * subject : String
     * notes : String
     * namecity : String
     * idvendor : String
     * emailtoname : String
     * ack : String
     * callflag : 0
     */

    private String token;
    private String tokensecret;
    private String idcia;
    private String idproject;
    private String idwebcare1;
    private String emailto;
    private String emailcc;
    private String subject;
    private String notes;
    private String namecity;
    private String idvendor;
    private String emailtoname;
    private String ack;
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

    public void setIdproject(String idproject) {
        this.idproject = idproject;
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

    public void setNamecity(String namecity) {
        this.namecity = namecity;
    }

    public void setIdvendor(String idvendor) {
        this.idvendor = idvendor;
    }

    public void setEmailtoname(String emailtoname) {
        this.emailtoname = emailtoname;
    }

    public void setAck(String ack) {
        this.ack = ack;
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

    public String getIdproject() {
        return idproject;
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

    public String getNamecity() {
        return namecity;
    }

    public String getIdvendor() {
        return idvendor;
    }

    public String getEmailtoname() {
        return emailtoname;
    }

    public String getAck() {
        return ack;
    }

    public int getCallflag() {
        return callflag;
    }
}
