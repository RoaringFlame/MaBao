package com.mabao.util.express;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class PackInfo {
    private String message;
    private String nu;
    private String ischeck;
    private String com;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatetime;
    private String status;
    private String condition;
    private List<PackDetails> data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNu() {
        return nu;
    }

    public void setNu(String nu) {
        this.nu = nu;
    }

    public String getIscheck() {
        return ischeck;
    }

    public void setIscheck(String ischeck) {
        this.ischeck = ischeck;
    }

    public String getCom() {
        return com;
    }

    public void setCom(String com) {
        this.com = com;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public List<PackDetails> getData() {
        return data;
    }

    public void setData(List<PackDetails> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("PackInfo [message=" + message + ", nu=" + nu + ", ischeck="
                + ischeck + ", com=" + com + ", updatetime=" + updatetime
                + ", status=" + status + ", condition=" + condition + "]");
        if (data != null) {
            for (PackDetails k : data) {
                s.append(k.toString());
            }
        }
        return s.toString();
    }

}
