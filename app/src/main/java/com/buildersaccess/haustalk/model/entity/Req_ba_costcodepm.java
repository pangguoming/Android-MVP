package com.buildersaccess.haustalk.model.entity;

/**
 * Created by pangg_000 on 1/20/2016.
 */
public class Req_ba_costcodepm {
    /**
     * token : String
     * tokensecret : String
     * idwarranty : String
     */

    private String token;
    private String tokensecret;
    private String idwarranty;

    public void setToken(String token) {
        this.token = token;
    }

    public void setTokensecret(String tokensecret) {
        this.tokensecret = tokensecret;
    }

    public void setIdwarranty(String idwarranty) {
        this.idwarranty = idwarranty;
    }

    public String getToken() {
        return token;
    }

    public String getTokensecret() {
        return tokensecret;
    }

    public String getIdwarranty() {
        return idwarranty;
    }
}
