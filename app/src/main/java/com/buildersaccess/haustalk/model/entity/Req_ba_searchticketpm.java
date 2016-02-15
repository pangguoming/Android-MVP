package com.buildersaccess.haustalk.model.entity;

/**
 * Created by pangg_000 on 1/20/2016.
 */
public class Req_ba_searchticketpm {
    /**
     * token : String
     * tokensecret : String
     * address : String
     * homeowner : String
     * status : String
     */

    private String token;
    private String tokensecret;
    private String address;
    private String homeowner;
    private String status;

    public void setToken(String token) {
        this.token = token;
    }

    public void setTokensecret(String tokensecret) {
        this.tokensecret = tokensecret;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setHomeowner(String homeowner) {
        this.homeowner = homeowner;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public String getTokensecret() {
        return tokensecret;
    }

    public String getAddress() {
        return address;
    }

    public String getHomeowner() {
        return homeowner;
    }

    public String getStatus() {
        return status;
    }
}
