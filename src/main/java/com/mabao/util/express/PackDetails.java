package com.mabao.util.express;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class PackDetails {

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;

    private String context;

    private String location;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date ftime;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getFtime() {
        return ftime;
    }

    public void setFtime(Date ftime) {
        this.ftime = ftime;
    }

    @Override
    public String toString() {
        return "PackDetails [time=" + time + ", location=" + location
                + ", context=" + context + ", ftime=" + ftime + "]";
    }

}
