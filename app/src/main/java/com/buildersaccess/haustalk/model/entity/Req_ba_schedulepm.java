package com.buildersaccess.haustalk.model.entity;

/**
 * Created by pangg_000 on 1/20/2016.
 */
public class Req_ba_schedulepm {
    /**
     * token : String
     * tokensecret : String
     * pmname : String
     * idwebcare1 : String
     * idwebcare1detail2 : String
     * scheduledate : String
     * schedulebesttime : String
     * scheduleconfirm : String
     */

    private String token;
    private String tokensecret;
    private String pmname;
    private String idwebcare1;
    private String idwebcare1detail2;
    private String scheduledate;
    private String schedulebesttime;
    private String scheduleconfirm;

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

    public void setIdwebcare1detail2(String idwebcare1detail2) {
        this.idwebcare1detail2 = idwebcare1detail2;
    }

    public void setScheduledate(String scheduledate) {
        this.scheduledate = scheduledate;
    }

    public void setSchedulebesttime(String schedulebesttime) {
        this.schedulebesttime = schedulebesttime;
    }

    public void setScheduleconfirm(String scheduleconfirm) {
        this.scheduleconfirm = scheduleconfirm;
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

    public String getIdwebcare1detail2() {
        return idwebcare1detail2;
    }

    public String getScheduledate() {
        return scheduledate;
    }

    public String getSchedulebesttime() {
        return schedulebesttime;
    }

    public String getScheduleconfirm() {
        return scheduleconfirm;
    }
}
