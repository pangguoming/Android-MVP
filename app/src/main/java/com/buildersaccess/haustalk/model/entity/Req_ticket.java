package com.buildersaccess.haustalk.model.entity;

/**
 * Created by pangg_000 on 1/20/2016.
 */
public class Req_ticket {
    /**
     * id : String
     * code : String
     * refid : String
     */

    private String id;
    private String code;
    private String refid;

    public void setId(String id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setRefid(String refid) {
        this.refid = refid;
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getRefid() {
        return refid;
    }
}
