package com.buildersaccess.haustalk.model.entity;

/**
 * Created by pangg_000 on 1/20/2016.
 */
public class Req_vendor {
    /**
     * id : String
     * code : String
     * iv : String
     */

    private String id;
    private String code;
    private String iv;

    public void setId(String id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getIv() {
        return iv;
    }
}
