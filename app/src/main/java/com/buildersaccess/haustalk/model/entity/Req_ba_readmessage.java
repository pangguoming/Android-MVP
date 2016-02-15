package com.buildersaccess.haustalk.model.entity;

/**
 * Created by pangg_000 on 1/20/2016.
 */
public class Req_ba_readmessage {
    /**
     * token : String
     * tokensecret : String
     * emailto : String
     * idwebcare1 : String
     * refid : String
     * acknowledgeby : String
     */

    private String token;
    private String tokensecret;
    private String emailto;
    private String idwebcare1;
    private String refid;
    private String acknowledgeby;

    public void setToken(String token) {
        this.token = token;
    }

    public void setTokensecret(String tokensecret) {
        this.tokensecret = tokensecret;
    }

    public void setEmailto(String emailto) {
        this.emailto = emailto;
    }

    public void setIdwebcare1(String idwebcare1) {
        this.idwebcare1 = idwebcare1;
    }

    public void setRefid(String refid) {
        this.refid = refid;
    }

    public void setAcknowledgeby(String acknowledgeby) {
        this.acknowledgeby = acknowledgeby;
    }

    public String getToken() {
        return token;
    }

    public String getTokensecret() {
        return tokensecret;
    }

    public String getEmailto() {
        return emailto;
    }

    public String getIdwebcare1() {
        return idwebcare1;
    }

    public String getRefid() {
        return refid;
    }

    public String getAcknowledgeby() {
        return acknowledgeby;
    }
}
