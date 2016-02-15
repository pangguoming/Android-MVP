package com.buildersaccess.haustalk.model.entity;

/**
 * Created by pangg_000 on 1/20/2016.
 */
public class Req_ba_homevendor {
    /**
     * token : String
     * tokensecret : String
     * idvendor : String
     */

    private String token;
    private String tokensecret;
    private String idvendor;

    public void setToken(String token) {
        this.token = token;
    }

    public void setTokensecret(String tokensecret) {
        this.tokensecret = tokensecret;
    }

    public void setIdvendor(String idvendor) {
        this.idvendor = idvendor;
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
}
