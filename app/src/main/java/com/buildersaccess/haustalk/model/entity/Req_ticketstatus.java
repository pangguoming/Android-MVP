package com.buildersaccess.haustalk.model.entity;

/**
 * Created by pangg_000 on 1/20/2016.
 */
public class Req_ticketstatus {
    /**
     * token : String
     * tokensecret : String
     * idcia : String
     * idproject : String
     * status : String
     */

    private String token;
    private String tokensecret;
    private String idcia;
    private String idproject;
    private String status;

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

    public void setStatus(String status) {
        this.status = status;
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

    public String getStatus() {
        return status;
    }
}
