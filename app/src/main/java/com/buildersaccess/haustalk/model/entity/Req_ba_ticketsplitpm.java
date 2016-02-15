package com.buildersaccess.haustalk.model.entity;

/**
 * Created by pangg_000 on 1/20/2016.
 */
public class Req_ba_ticketsplitpm {
    /**
     * token : String
     * tokensecret : String
     * pmname : String
     * idwebcare1 : String
     * hemail : String
     * hname : String
     */

    private String token;
    private String tokensecret;
    private String pmname;
    private String idwebcare1;
    private String hemail;
    private String hname;

    public void setToken(String token) {
        this.token = token;
    }

    public void setTokensecret(String tokensecret) {
        this.tokensecret = tokensecret;
    }

    public void setPmname(String pmname) {
        this.pmname = pmname;
    }

    public void setIdwebcare1(String idwebcare1) {
        this.idwebcare1 = idwebcare1;
    }

    public void setHemail(String hemail) {
        this.hemail = hemail;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    public String getToken() {
        return token;
    }

    public String getTokensecret() {
        return tokensecret;
    }

    public String getPmname() {
        return pmname;
    }

    public String getIdwebcare1() {
        return idwebcare1;
    }

    public String getHemail() {
        return hemail;
    }

    public String getHname() {
        return hname;
    }
}
