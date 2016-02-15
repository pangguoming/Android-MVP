package com.buildersaccess.haustalk.model.entity;

/**
 * Created by pangg_000 on 1/20/2016.
 */
public class Req_ba_tickethistoryvendor {
    /**
     * token : String
     * tokensecret : String
     * idvendor : String
     * idwebcare1 : String
     * idcia : String
     */

    private String token;
    private String tokensecret;
    private String idvendor;
    private String idwebcare1;
    private String idcia;

    public void setToken(String token) {
        this.token = token;
    }

    public void setTokensecret(String tokensecret) {
        this.tokensecret = tokensecret;
    }

    public void setIdvendor(String idvendor) {
        this.idvendor = idvendor;
    }

    public void setIdwebcare1(String idwebcare1) {
        this.idwebcare1 = idwebcare1;
    }

    public void setIdcia(String idcia) {
        this.idcia = idcia;
    }

    public String getToken() {
        return token;
    }

    public String getTokensecret() {
        return tokensecret;
    }

    public String getIdvendor() {
        return idvendor;
    }

    public String getIdwebcare1() {
        return idwebcare1;
    }

    public String getIdcia() {
        return idcia;
    }
}
