package com.buildersaccess.haustalk.model.entity;

/**
 * Created by pangg_000 on 1/20/2016.
 */
public class Req_cancelsurvey {
    /**
     * idnumber : 0
     * code : 0
     * token : String
     * tokensecret : String
     * idwebcare1 : 0
     * notes : String
     */

    private int idnumber;
    private int code;
    private String token;
    private String tokensecret;
    private int idwebcare1;
    private String notes;

    public void setIdnumber(int idnumber) {
        this.idnumber = idnumber;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setTokensecret(String tokensecret) {
        this.tokensecret = tokensecret;
    }

    public void setIdwebcare1(int idwebcare1) {
        this.idwebcare1 = idwebcare1;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getIdnumber() {
        return idnumber;
    }

    public int getCode() {
        return code;
    }

    public String getToken() {
        return token;
    }

    public String getTokensecret() {
        return tokensecret;
    }

    public int getIdwebcare1() {
        return idwebcare1;
    }

    public String getNotes() {
        return notes;
    }
}
