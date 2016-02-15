package com.buildersaccess.haustalk.model.entity;

/**
 * Created by pangg_000 on 1/20/2016.
 */
public class Req_hold_update {
    /**
     * token : String
     * tokensecret : String
     * level : String
     * idwebcare1 : String
     */

    private String token;
    private String tokensecret;
    private String level;
    private String idwebcare1;

    public void setToken(String token) {
        this.token = token;
    }

    public void setTokensecret(String tokensecret) {
        this.tokensecret = tokensecret;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setIdwebcare1(String idwebcare1) {
        this.idwebcare1 = idwebcare1;
    }

    public String getToken() {
        return token;
    }

    public String getTokensecret() {
        return tokensecret;
    }

    public String getLevel() {
        return level;
    }

    public String getIdwebcare1() {
        return idwebcare1;
    }
}
