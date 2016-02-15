package com.buildersaccess.haustalk.model.entity;

/**
 * Created by pangg_000 on 1/20/2016.
 */
public class Req_warrantyimg {
    /**
     * idnumber : String
     * idwebcare1 : String
     * idwebcare1detail : String
     * thub : String
     */

    private String idnumber;
    private String idwebcare1;
    private String idwebcare1detail;
    private String thub;

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public void setIdwebcare1(String idwebcare1) {
        this.idwebcare1 = idwebcare1;
    }

    public void setIdwebcare1detail(String idwebcare1detail) {
        this.idwebcare1detail = idwebcare1detail;
    }

    public void setThub(String thub) {
        this.thub = thub;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public String getIdwebcare1() {
        return idwebcare1;
    }

    public String getIdwebcare1detail() {
        return idwebcare1detail;
    }

    public String getThub() {
        return thub;
    }
}
