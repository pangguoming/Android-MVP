package com.buildersaccess.haustalk.model.entity;

/**
 * Created by pangg_000 on 1/20/2016.
 */
public class Req_deletedraft {
    /**
     * token : String
     * tokensecret : String
     * idcia : String
     * idproject : String
     * idwebcare1 : String
     * idwebcare1detail : String
     */

    private String token;
    private String tokensecret;
    private String idcia;
    private String idproject;
    private String idwebcare1;
    private String idwebcare1detail;

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

    public void setIdwebcare1detail(String idwebcare1detail) {
        this.idwebcare1detail = idwebcare1detail;
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

    public String getIdwebcare1detail() {
        return idwebcare1detail;
    }
}
