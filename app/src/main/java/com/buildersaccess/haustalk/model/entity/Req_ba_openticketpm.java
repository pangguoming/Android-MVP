package com.buildersaccess.haustalk.model.entity;

/**
 * Created by pangg_000 on 1/20/2016.
 */
public class Req_ba_openticketpm {
    /**
     * token : String
     * tokensecret : String
     * page : 0
     */

    private String token;
    private String tokensecret;
    private int page;

    public void setToken(String token) {
        this.token = token;
    }

    public void setTokensecret(String tokensecret) {
        this.tokensecret = tokensecret;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getToken() {
        return token;
    }

    public String getTokensecret() {
        return tokensecret;
    }

    public int getPage() {
        return page;
    }
}
