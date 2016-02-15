package com.buildersaccess.haustalk.model.entity;

/**
 * Created by pangg_000 on 1/20/2016.
 */
public class Req_profileemail {
    /**
     * token : String
     * tokensecret : String
     * idcia : String
     * idproject : String
     * oldemail : String
     * newemail : String
     */

    private String token;
    private String tokensecret;
    private String idcia;
    private String idproject;
    private String oldemail;
    private String newemail;

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

    public void setOldemail(String oldemail) {
        this.oldemail = oldemail;
    }

    public void setNewemail(String newemail) {
        this.newemail = newemail;
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

    public String getOldemail() {
        return oldemail;
    }

    public String getNewemail() {
        return newemail;
    }
}
