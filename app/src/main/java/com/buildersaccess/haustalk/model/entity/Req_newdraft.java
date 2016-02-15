package com.buildersaccess.haustalk.model.entity;

/**
 * Created by pangg_000 on 1/20/2016.
 */
public class Req_newdraft {
    /**
     * token : String
     * tokensecret : String
     * idcia : String
     * idproject : String
     * catid : String
     * category : String
     * servicenotes : String
     * photo : String
     * creaby : String
     */

    private String token;
    private String tokensecret;
    private String idcia;
    private String idproject;
    private String catid;
    private String category;
    private String servicenotes;
    private String photo;
    private String creaby;

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

    public void setCatid(String catid) {
        this.catid = catid;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setServicenotes(String servicenotes) {
        this.servicenotes = servicenotes;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setCreaby(String creaby) {
        this.creaby = creaby;
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

    public String getCatid() {
        return catid;
    }

    public String getCategory() {
        return category;
    }

    public String getServicenotes() {
        return servicenotes;
    }

    public String getPhoto() {
        return photo;
    }

    public String getCreaby() {
        return creaby;
    }
}
