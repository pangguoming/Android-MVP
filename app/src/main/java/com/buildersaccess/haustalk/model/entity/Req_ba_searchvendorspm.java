package com.buildersaccess.haustalk.model.entity;

/**
 * Created by pangg_000 on 1/20/2016.
 */
public class Req_ba_searchvendorspm {
    /**
     * token : String
     * tokensecret : String
     * idcia : String
     * idproject : String
     * idcostcode : String
     * keyword : String
     */

    private String token;
    private String tokensecret;
    private String idcia;
    private String idproject;
    private String idcostcode;
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

    public void setIdproject(String idproject) {
        this.idproject = idproject;
    }

    public void setIdcostcode(String idcostcode) {
        this.idcostcode = idcostcode;
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

    public String getIdproject() {
        return idproject;
    }

    public String getIdcostcode() {
        return idcostcode;
    }

    public String getKeyword() {
        return keyword;
    }
}
