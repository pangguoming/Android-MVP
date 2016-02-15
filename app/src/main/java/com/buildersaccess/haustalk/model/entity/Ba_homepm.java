package com.buildersaccess.haustalk.model.entity;

import java.util.List;

/**
 * Created by pangg_000 on 1/25/2016.
 */
public class Ba_homepm {
    private String  validtoken;
    private String  found ;
    private List<HomevendorDat> projects ;
    private List<HomevendorDat> unassigned ;
    private List<CMessage> messages ;

    public String getValidtoken() {
        return validtoken;
    }

    public void setValidtoken(String validtoken) {
        this.validtoken = validtoken;
    }

    public String getFound() {
        return found;
    }

    public void setFound(String found) {
        this.found = found;
    }

    public List<HomevendorDat> getProjects() {
        return projects;
    }

    public void setProjects(List<HomevendorDat> projects) {
        this.projects = projects;
    }

    public List<HomevendorDat> getUnassigned() {
        return unassigned;
    }

    public void setUnassigned(List<HomevendorDat> unassigned) {
        this.unassigned = unassigned;
    }

    public List<CMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<CMessage> messages) {
        this.messages = messages;
    }
    

}

