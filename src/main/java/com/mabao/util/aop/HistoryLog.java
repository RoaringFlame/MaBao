package com.mabao.util.aop;

import com.mabao.pojo.GoodsType;
import com.mabao.repository.GoodsTypeRepository;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;

@Aspect
public class HistoryLog {

    @Autowired
    private GoodsTypeRepository goodsTypeRepository;

    @AfterReturning("execution(* com.mabao.service.GoodsService.goodsSearch(Long,String,..))" +
            "&& args(goodsTypeId,title,..)")
    public void changeGoodsState(Long goodsTypeId, String title) {
        String typeName = "";
        if (goodsTypeId == null) {
            typeName = "所有";
        } else {
            GoodsType goodsType = this.goodsTypeRepository.findOne(goodsTypeId);
            typeName = goodsType.getTypeName();
        }
        if (title == null || "".equals(title)) title = "空白";
        System.out.println("---------------typeName = " + typeName +
                "-------------title = " + title + "---------------------");
    }
}