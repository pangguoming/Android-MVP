package com.buildersaccess.haustalk.model.entity;

/**
 * Created by pangg_000 on 1/20/2016.
 */
public class Req_message {
    /**
     * id : String
     * code : String
     * ack : String
     */

    private String id;
    private String code;
    private String ack;

    public void setId(String id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setAck(String ack) {
        this.ack = ack;
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getAck() {
        return ack;
    }
}
