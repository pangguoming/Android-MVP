package com.buildersaccess.haustalk.model.entity;

import java.util.List;

/**
 * Created by pangg_000 on 2/1/2016.
 */
public class Homevendor {
    private String validtoken;
    private String found;
    private List<HomevendorDat> projects;
    private List<cMessage> messages;

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

    public List<cMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<cMessage> messages) {
        this.messages = messages;
    }

    public static class cMessage
    {
        private String idnumber;
        private String creaby;
        private String creadate;
        private String acknowledgeby;
        private String acknowledgedate;
        private String emailto;
        private String emailto2;
        private String subject;
        private String notes;
        private String idwebcare1;
        private String idcia;
        private String callflag;

        public String getIdnumber() {
            return idnumber;
        }

        public void setIdnumber(String idnumber) {
            this.idnumber = idnumber;
        }

        public String getCreaby() {
            return creaby;
        }

        public void setCreaby(String creaby) {
            this.creaby = creaby;
        }

        public String getCreadate() {
            return creadate;
        }

        public void setCreadate(String creadate) {
            this.creadate = creadate;
        }

        public String getAcknowledgeby() {
            return acknowledgeby;
        }

        public void setAcknowledgeby(String acknowledgeby) {
            this.acknowledgeby = acknowledgeby;
        }

        public String getAcknowledgedate() {
            return acknowledgedate;
        }

        public void setAcknowledgedate(String acknowledgedate) {
            this.acknowledgedate = acknowledgedate;
        }

        public String getEmailto() {
            return emailto;
        }

        public void setEmailto(String emailto) {
            this.emailto = emailto;
        }

        public String getEmailto2() {
            return emailto2;
        }

        public void setEmailto2(String emailto2) {
            this.emailto2 = emailto2;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getNotes() {
            return notes;
        }

        public void setNotes(String notes) {
            this.notes = notes;
        }

        public String getIdwebcare1() {
            return idwebcare1;
        }

        public void setIdwebcare1(String idwebcare1) {
            this.idwebcare1 = idwebcare1;
        }

        public String getIdcia() {
            return idcia;
        }

        public void setIdcia(String idcia) {
            this.idcia = idcia;
        }

        public String getCallflag() {
            return callflag;
        }

        public void setCallflag(String callflag) {
            this.callflag = callflag;
        }
    }
}
