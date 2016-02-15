package com.buildersaccess.haustalk.model.entity;

/**
 * Created by pangg_000 on 1/20/2016.
 */
public class Req_ba_assignbuilderpm {
    /**
     * token : String
     * tokensecret : String
     * idwebcare1 : String
     * assignto : String
     * assignpm : String
     * assigemail : String
     */

    private String token;
    private String tokensecret;
    private String idwebcare1;
    private String assignto;
    private String assignpm;
    private String assigemail;

    public void setToken(String token) {
        this.token = token;
    }

    public void setTokensecret(String tokensecret) {
        this.tokensecret = tokensecret;
    }

    public void setIdwebcare1(String idwebcare1) {
        this.idwebcare1 = idwebcare1;
    }

    public void setAssignto(String assignto) {
        this.assignto = assignto;
    }

    public void setAssignpm(String assignpm) {
        this.assignpm = assignpm;
    }

    public void setAssigemail(String assigemail) {
        this.assigemail = assigemail;
    }

    public String getToken() {
        return token;
    }

    public String getTokensecret() {
        return tokensecret;
    }

    public String getIdwebcare1() {
        return idwebcare1;
    }

    public String getAssignto() {
        return assignto;
    }

    public String getAssignpm() {
        return assignpm;
    }

    public String getAssigemail() {
        return assigemail;
    }
}
