package com.mabao.controller.rest;

import com.mabao.controller.vo.GoodsVO;
import com.mabao.controller.vo.JsonResultVO;
import com.mabao.pojo.Goods;
import com.mabao.service.ShoppingService;
import com.mabao.util.PageVO;
import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


@RestController
@RequestMapping(value = "/cart")
public class CartRESTController {
    @Autowired
    private ShoppingService shoppingService;

    /**
     * 用户购物车中商品列表
     * @return                  商品list
     */
    @RequestMapping( method = GET)
    public PageVO<GoodsVO> findUserCartGoods() {
        //查询该用户购物车剩余商品
        Page<Goods> goodsPage = this.shoppingService.findAllGoodsByUser();
        PageVO<GoodsVO> pageVO = new PageVO<>();
        pageVO.setItems(GoodsVO.generateBy(goodsPage.getContent()));
        pageVO.setCurrentPage(goodsPage.getNumber()+1);
        pageVO.setTotalRow(goodsPage.getTotalElements());
        pageVO.setPageSize(goodsPage.getSize());
        return pageVO;
    }

    /**
     * 删除购物车内商品
     * @param goodsId           商品ID
     * @return                  结果VO
     */
    @RequestMapping(value = "/goods/{goodsId}", method = RequestMethod.DELETE)
    public JsonResultVO deleteShoppingCartGoods(@PathVariable Integer goodsId) {
        //移除购物车内商品，查询该用户购物车剩余商品
        return this.shoppingService.deleteCartGoods(goodsId);
    }
}
