package com.buildersaccess.haustalk.model.entity;

import java.util.List;

/**
 * Created by pangg_000 on 2/2/2016.
 */
public class Ba_ticketpm {
    private String validtoken;
    private String found;
    private String message;
    private String email1;
    private String email2;
    private cTicket ticket;
    private List<cTicketDetail> listticketdetail;
    private List<CMessage> listmessage;

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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public cTicket getTicket() {
        return ticket;
    }

    public void setTicket(cTicket ticket) {
        this.ticket = ticket;
    }

    public List<cTicketDetail> getListticketdetail() {
        return listticketdetail;
    }

    public void setListticketdetail(List<cTicketDetail> listticketdetail) {
        this.listticketdetail = listticketdetail;
    }

    public List<CMessage> getListmessage() {
        return listmessage;
    }

    public void setListmessage(List<CMessage> listmessage) {
        this.listmessage = listmessage;
    }

    public static class cTicket
    {
        private String idwebcare1;
        private String creaby;
        private String creadate;
        private String modiby;
        private String modidate;
        private String acknowledgeby;
        private String acknowledgedate;
        private String archiveby;
        private String archivedate;
        private String assignto;
        private String assignpm;
        private String assigemail;
        private String status;
        private String cusname;
        private String address;
        private String bestdate1;
        private String bestdate2;
        private String bestdate1time;
        private String bestdate2time;
        private String besttime;
        private String contactby;
        private String phone;
        private String workphone;
        private String idcia;
        private String idproject;
        private String homeowneremail;
        private List<String> servicenotes;
        private String closed;
        private String slab;
        private String assignmobile;
        private String assigntel;
        private String assigntelhome;
        private String cianame;
        private String latitude;
        private String longitude;

        private String followup;
        private String followupname;
        private String followupemail;
        private String followupmobile;
        private String followuptel;
        private String followuptelhome;

        private String selectionyn;

        public String getIdwebcare1() {
            return idwebcare1;
        }

        public void setIdwebcare1(String idwebcare1) {
            this.idwebcare1 = idwebcare1;
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

        public String getModiby() {
            return modiby;
        }

        public void setModiby(String modiby) {
            this.modiby = modiby;
        }

        public String getModidate() {
            return modidate;
        }

        public void setModidate(String modidate) {
            this.modidate = modidate;
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

        public String getArchiveby() {
            return archiveby;
        }

        public void setArchiveby(String archiveby) {
            this.archiveby = archiveby;
        }

        public String getArchivedate() {
            return archivedate;
        }

        public void setArchivedate(String archivedate) {
            this.archivedate = archivedate;
        }

        public String getAssignto() {
            return assignto;
        }

        public void setAssignto(String assignto) {
            this.assignto = assignto;
        }

        public String getAssignpm() {
            return assignpm;
        }

        public void setAssignpm(String assignpm) {
            this.assignpm = assignpm;
        }

        public String getAssigemail() {
            return assigemail;
        }

        public void setAssigemail(String assigemail) {
            this.assigemail = assigemail;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCusname() {
            return cusname;
        }

        public void setCusname(String cusname) {
            this.cusname = cusname;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getBestdate1() {
            return bestdate1;
        }

        public void setBestdate1(String bestdate1) {
            this.bestdate1 = bestdate1;
        }

        public String getBestdate2() {
            return bestdate2;
        }

        public void setBestdate2(String bestdate2) {
            this.bestdate2 = bestdate2;
        }

        public String getBestdate1time() {
            return bestdate1time;
        }

        public void setBestdate1time(String bestdate1time) {
            this.bestdate1time = bestdate1time;
        }

        public String getBestdate2time() {
            return bestdate2time;
        }

        public void setBestdate2time(String bestdate2time) {
            this.bestdate2time = bestdate2time;
        }

        public String getBesttime() {
            return besttime;
        }

        public void setBesttime(String besttime) {
            this.besttime = besttime;
        }

        public String getContactby() {
            return contactby;
        }

        public void setContactby(String contactby) {
            this.contactby = contactby;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getWorkphone() {
            return workphone;
        }

        public void setWorkphone(String workphone) {
            this.workphone = workphone;
        }

        public String getIdcia() {
            return idcia;
        }

        public void setIdcia(String idcia) {
            this.idcia = idcia;
        }

        public String getIdproject() {
            return idproject;
        }

        public void setIdproject(String idproject) {
            this.idproject = idproject;
        }

        public String getHomeowneremail() {
            return homeowneremail;
        }

        public void setHomeowneremail(String homeowneremail) {
            this.homeowneremail = homeowneremail;
        }

        public List<String> getServicenotes() {
            return servicenotes;
        }

        public void setServicenotes(List<String> servicenotes) {
            this.servicenotes = servicenotes;
        }

        public String getClosed() {
            return closed;
        }

        public void setClosed(String closed) {
            this.closed = closed;
        }

        public String getSlab() {
            return slab;
        }

        public void setSlab(String slab) {
            this.slab = slab;
        }

        public String getAssignmobile() {
            return assignmobile;
        }

        public void setAssignmobile(String assignmobile) {
            this.assignmobile = assignmobile;
        }

        public String getAssigntel() {
            return assigntel;
        }

        public void setAssigntel(String assigntel) {
            this.assigntel = assigntel;
        }

        public String getAssigntelhome() {
            return assigntelhome;
        }

        public void setAssigntelhome(String assigntelhome) {
            this.assigntelhome = assigntelhome;
        }

        public String getCianame() {
            return cianame;
        }

        public void setCianame(String cianame) {
            this.cianame = cianame;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getFollowup() {
            return followup;
        }

        public void setFollowup(String followup) {
            this.followup = followup;
        }

        public String getFollowupname() {
            return followupname;
        }

        public void setFollowupname(String followupname) {
            this.followupname = followupname;
        }

        public String getFollowupemail() {
            return followupemail;
        }

        public void setFollowupemail(String followupemail) {
            this.followupemail = followupemail;
        }

        public String getFollowupmobile() {
            return followupmobile;
        }

        public void setFollowupmobile(String followupmobile) {
            this.followupmobile = followupmobile;
        }

        public String getFollowuptel() {
            return followuptel;
        }

        public void setFollowuptel(String followuptel) {
            this.followuptel = followuptel;
        }

        public String getFollowuptelhome() {
            return followuptelhome;
        }

        public void setFollowuptelhome(String followuptelhome) {
            this.followuptelhome = followuptelhome;
        }

        public String getSelectionyn() {
            return selectionyn;
        }

        public void setSelectionyn(String selectionyn) {
            this.selectionyn = selectionyn;
        }
    }
    public static class cTicketDetail
    {
        private String idnumber;
        private String workingby;
        private String workingdate;
        private String finishby;
        private String finishdate;
        private String status2;
        private String catdescription;
        private String servicenotes;
        private String catid;

        private List<cTask> listtask;
        private List<cPhoto> listphoto;

        public String getIdnumber() {
            return idnumber;
        }

        public void setIdnumber(String idnumber) {
            this.idnumber = idnumber;
        }

        public String getWorkingby() {
            return workingby;
        }

        public void setWorkingby(String workingby) {
            this.workingby = workingby;
        }

        public String getWorkingdate() {
            return workingdate;
        }

        public void setWorkingdate(String workingdate) {
            this.workingdate = workingdate;
        }

        public String getFinishby() {
            return finishby;
        }

        public void setFinishby(String finishby) {
            this.finishby = finishby;
        }

        public String getFinishdate() {
            return finishdate;
        }

        public void setFinishdate(String finishdate) {
            this.finishdate = finishdate;
        }

        public String getStatus2() {
            return status2;
        }

        public void setStatus2(String status2) {
            this.status2 = status2;
        }

        public String getCatdescription() {
            return catdescription;
        }

        public void setCatdescription(String catdescription) {
            this.catdescription = catdescription;
        }

        public String getServicenotes() {
            return servicenotes;
        }

        public void setServicenotes(String servicenotes) {
            this.servicenotes = servicenotes;
        }

        public String getCatid() {
            return catid;
        }

        public void setCatid(String catid) {
            this.catid = catid;
        }

        public List<cTask> getListtask() {
            return listtask;
        }

        public void setListtask(List<cTask> listtask) {
            this.listtask = listtask;
        }

        public List<cPhoto> getListphoto() {
            return listphoto;
        }

        public void setListphoto(List<cPhoto> listphoto) {
            this.listphoto = listphoto;
        }

        public static class cTask
        {
            private String idnumber;
            private String tasknumber;
            private String idvendor;
            private String vendoremail;
            private String vendorcontact;
            private String nvendor;
            private String duration;
            private String status;
            private String buildernotes;
            private String vendorschedule;
            private String schedulebesttime;
            private String scheduleconfirm;

            private String workingby;
            private String workingdate;
            private String finishby;
            private String finishdate;
            private String vendoracknowledge;

            private String vendorphone1;
            private String vendorphone2;
            private String vendorphone3;

            public String getIdnumber() {
                return idnumber;
            }

            public void setIdnumber(String idnumber) {
                this.idnumber = idnumber;
            }

            public String getTasknumber() {
                return tasknumber;
            }

            public void setTasknumber(String tasknumber) {
                this.tasknumber = tasknumber;
            }

            public String getIdvendor() {
                return idvendor;
            }

            public void setIdvendor(String idvendor) {
                this.idvendor = idvendor;
            }

            public String getVendoremail() {
                return vendoremail;
            }

            public void setVendoremail(String vendoremail) {
                this.vendoremail = vendoremail;
            }

            public String getVendorcontact() {
                return vendorcontact;
            }

            public void setVendorcontact(String vendorcontact) {
                this.vendorcontact = vendorcontact;
            }

            public String getNvendor() {
                return nvendor;
            }

            public void setNvendor(String nvendor) {
                this.nvendor = nvendor;
            }

            public String getDuration() {
                return duration;
            }

            public void setDuration(String duration) {
                this.duration = duration;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getBuildernotes() {
                return buildernotes;
            }

            public void setBuildernotes(String buildernotes) {
                this.buildernotes = buildernotes;
            }

            public String getVendorschedule() {
                return vendorschedule;
            }

            public void setVendorschedule(String vendorschedule) {
                this.vendorschedule = vendorschedule;
            }

            public String getSchedulebesttime() {
                return schedulebesttime;
            }

            public void setSchedulebesttime(String schedulebesttime) {
                this.schedulebesttime = schedulebesttime;
            }

            public String getScheduleconfirm() {
                return scheduleconfirm;
            }

            public void setScheduleconfirm(String scheduleconfirm) {
                this.scheduleconfirm = scheduleconfirm;
            }

            public String getWorkingby() {
                return workingby;
            }

            public void setWorkingby(String workingby) {
                this.workingby = workingby;
            }

            public String getWorkingdate() {
                return workingdate;
            }

            public void setWorkingdate(String workingdate) {
                this.workingdate = workingdate;
            }

            public String getFinishby() {
                return finishby;
            }

            public void setFinishby(String finishby) {
                this.finishby = finishby;
            }

            public String getFinishdate() {
                return finishdate;
            }

            public void setFinishdate(String finishdate) {
                this.finishdate = finishdate;
            }

            public String getVendoracknowledge() {
                return vendoracknowledge;
            }

            public void setVendoracknowledge(String vendoracknowledge) {
                this.vendoracknowledge = vendoracknowledge;
            }

            public String getVendorphone1() {
                return vendorphone1;
            }

            public void setVendorphone1(String vendorphone1) {
                this.vendorphone1 = vendorphone1;
            }

            public String getVendorphone2() {
                return vendorphone2;
            }

            public void setVendorphone2(String vendorphone2) {
                this.vendorphone2 = vendorphone2;
            }

            public String getVendorphone3() {
                return vendorphone3;
            }

            public void setVendorphone3(String vendorphone3) {
                this.vendorphone3 = vendorphone3;
            }
        }
        public static class cPhoto
        {
            private String idnumber;
            private String idwebcare1;
            private String idwebcare1detail;
            private String creadate;
            private String creaby;
            private String xtag;

            public String getIdnumber() {
                return idnumber;
            }

            public void setIdnumber(String idnumber) {
                this.idnumber = idnumber;
            }

            public String getIdwebcare1() {
                return idwebcare1;
            }

            public void setIdwebcare1(String idwebcare1) {
                this.idwebcare1 = idwebcare1;
            }

            public String getIdwebcare1detail() {
                return idwebcare1detail;
            }

            public void setIdwebcare1detail(String idwebcare1detail) {
                this.idwebcare1detail = idwebcare1detail;
            }

            public String getCreadate() {
                return creadate;
            }

            public void setCreadate(String creadate) {
                this.creadate = creadate;
            }

            public String getCreaby() {
                return creaby;
            }

            public void setCreaby(String creaby) {
                this.creaby = creaby;
            }

            public String getXtag() {
                return xtag;
            }

            public void setXtag(String xtag) {
                this.xtag = xtag;
            }
        }
    }

}
