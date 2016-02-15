package com.buildersaccess.haustalk.model.entity;

/**
 * Created by pangg_000 on 1/20/2016.
 */
public class Req_ba_nonwarrantablepm {
    /**
     * token : String
     * tokensecret : String
     * refid : String
     * pmname : String
     */

    private String token;
    private String tokensecret;
    private String refid;
    private String pmname;

    public void setToken(String token) {
        this.token = token;
    }

    public void setTokensecret(String tokensecret) {
        this.tokensecret = tokensecret;
    }

    public void setRefid(String refid) {
        this.refid = refid;
    }

    public void setPmname(String pmname) {
        this.pmname = pmname;
    }

    public String getToken() {
        return token;
    }

    public String getTokensecret() {
        return tokensecret;
    }

    public String getRefid() {
        return refid;
    }

    public String getPmname() {
        return pmname;
    }
}
