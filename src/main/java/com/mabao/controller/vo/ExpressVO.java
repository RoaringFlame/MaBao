package com.mabao.controller.vo;

import com.mabao.util.express.PackInfo;

import java.util.List;

public class ExpressVO {
    private String company;
    private String portNum;
    private List<ExpressContentVO> contentList;

    public static ExpressVO generateBy(PackInfo packInfo){
        ExpressVO vo = new ExpressVO();
        vo.setCompany(packInfo.getCom());
        vo.setPortNum(packInfo.getNu());
        vo.setContentList(ExpressContentVO.generateBy(packInfo.getData()));
        return vo;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPortNum() {
        return portNum;
    }

    public void setPortNum(String portNum) {
        this.portNum = portNum;
    }

    public List<ExpressContentVO> getContentList() {
        return contentList;
    }

    public void setContentList(List<ExpressContentVO> contentList) {
        this.contentList = contentList;
    }
}
