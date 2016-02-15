package com.buildersaccess.haustalk.model.entity;

/**
 * Created by pangg_000 on 1/20/2016.
 */
public class Req_ba_searchbuilderspm {
    /**
     * token : String
     * tokensecret : String
     * idcia : String
     * keyword : String
     */

    private String token;
    private String tokensecret;
    private String idcia;
    private String keyword;

    public void setToken(String token) {
        this.token = token;
    }

    public void setTokensecret(String tokensecret) {
        this.tokensecret = tokensecret;
    }

    public void setIdcia(String idcia) {
        this.idcia = idcia;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
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

    public String getKeyword() {
        return keyword;
    }
}
