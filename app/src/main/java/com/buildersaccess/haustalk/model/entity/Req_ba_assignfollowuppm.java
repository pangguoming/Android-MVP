package com.buildersaccess.haustalk.model.entity;

/**
 * Created by pangg_000 on 1/20/2016.
 */
public class Req_ba_assignfollowuppm {
    /**
     * token : String
     * tokensecret : String
     * idwebcare1 : String
     * followup : String
     * followupname : String
     * followupemail : String
     */

    private String token;
    private String tokensecret;
    private String idwebcare1;
    private String followup;
    private String followupname;
    private String followupemail;

    public void setToken(String token) {
        this.token = token;
    }

    public void setTokensecret(String tokensecret) {
        this.tokensecret = tokensecret;
    }

    public void setIdwebcare1(String idwebcare1) {
        this.idwebcare1 = idwebcare1;
    }

    public void setFollowup(String followup) {
        this.followup = followup;
    }

    public void setFollowupname(String followupname) {
        this.followupname = followupname;
    }

    public void setFollowupemail(String followupemail) {
        this.followupemail = followupemail;
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

    public String getFollowup() {
        return followup;
    }

    public String getFollowupname() {
        return followupname;
    }

    public String getFollowupemail() {
        return followupemail;
    }
}
