package com.mabao.controller.vo;

import com.mabao.util.VoUtil;
import com.mabao.util.express.PackDetails;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ExpressContentVO {
    private String time;
    private String context;

    public static ExpressContentVO generateBy(PackDetails packDetails){
        ExpressContentVO vo = VoUtil.copyBasic(ExpressContentVO.class,packDetails);
        SimpleDateFormat myFmt=new SimpleDateFormat("E yyyy-MM-dd HH:mm:ss");
        assert vo != null;
        vo.setTime(myFmt.format(packDetails.getTime()));
        return vo;
    }

    public static List<ExpressContentVO> generateBy(List<PackDetails> packDetailsList){
        List<ExpressContentVO> list = new ArrayList<>();
        for(PackDetails packDetails: packDetailsList){
            list.add(generateBy(packDetails));
        }
        return list;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
