package com.buildersaccess.haustalk.model.entity;

/**
 * Created by pangg_000 on 1/20/2016.
 */
public class Req_ba_jobfinishpm {
    /**
     * token : String
     * tokensecret : String
     * pmname : String
     * idwebcare1 : String
     * idwebcare1detail : String
     * idwebcare1detail2 : String
     * xphoto : String
     * printname : String
     */

    private String token;
    private String tokensecret;
    private String pmname;
    private String idwebcare1;
    private String idwebcare1detail;
    private String idwebcare1detail2;
    private String xphoto;
    private String printname;

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

    public void setIdwebcare1detail(String idwebcare1detail) {
        this.idwebcare1detail = idwebcare1detail;
    }

    public void setIdwebcare1detail2(String idwebcare1detail2) {
        this.idwebcare1detail2 = idwebcare1detail2;
    }

    public void setXphoto(String xphoto) {
        this.xphoto = xphoto;
    }

    public void setPrintname(String printname) {
        this.printname = printname;
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

    public String getIdwebcare1detail() {
        return idwebcare1detail;
    }

    public String getIdwebcare1detail2() {
        return idwebcare1detail2;
    }

    public String getXphoto() {
        return xphoto;
    }

    public String getPrintname() {
        return printname;
    }
}
