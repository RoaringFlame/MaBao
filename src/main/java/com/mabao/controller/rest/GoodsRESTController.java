package com.mabao.controller.rest;

import com.mabao.controller.vo.GoodsVO;
import com.mabao.util.PageVO;
import com.mabao.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by maxu on 2016/6/30.
 */
@RestController
@RequestMapping(value = "/goods")
public class GoodsRESTController {
    @Autowired
    private GoodsService goodsService;

    /**
     * （首页猜你喜欢）
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/goodsLike",method = RequestMethod.POST,produces = "application/json;charset:UTF-8")
    public PageVO<GoodsVO> goodsList(int page,int pageSize) {
        return this.goodsService.getPageVO(page, pageSize);
    }
}
