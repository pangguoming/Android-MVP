package com.buildersaccess.haustalk.model.entity;

/**
 * Created by pangg_000 on 1/20/2016.
 */
public class Req_profilecontact {
    /**
     * token : String
     * tokensecret : String
     * idcia : String
     * idproject : String
     * ownername : String
     * phone : String
     * workphone : String
     * besttime : String
     */

    private String token;
    private String tokensecret;
    private String idcia;
    private String idproject;
    private String ownername;
    private String phone;
    private String workphone;
    private String besttime;

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

    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setWorkphone(String workphone) {
        this.workphone = workphone;
    }

    public void setBesttime(String besttime) {
        this.besttime = besttime;
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

    public String getOwnername() {
        return ownername;
    }

    public String getPhone() {
        return phone;
    }

    public String getWorkphone() {
        return workphone;
    }

    public String getBesttime() {
        return besttime;
    }
}
