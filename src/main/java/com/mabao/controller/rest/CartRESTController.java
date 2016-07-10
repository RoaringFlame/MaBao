package com.mabao.controller.rest;

import com.mabao.controller.vo.GoodsVO;
import com.mabao.controller.vo.JsonResultVO;
import com.mabao.pojo.Goods;
import com.mabao.service.CartService;
import com.mabao.util.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


@RestController
@RequestMapping(value = "/cart")
public class CartRESTController {
    @Autowired
    private CartService cartService;

    /**
     * 用户购物车中商品列表
     * @return                  商品list
     */
    @RequestMapping( method = GET)
    public PageVO<GoodsVO> findUserCartGoods(@RequestParam(value = "userId", defaultValue = "1")
                                                 Long userId) {
        //查询该用户购物车剩余商品
        Page<Goods> goodsPage = this.cartService.findAllGoodsByUser(userId);
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
    public JsonResultVO deleteShoppingCartGoods(@RequestParam(value = "userId", defaultValue = "1") Long userId,
                                                @PathVariable Integer goodsId) {
        //移除购物车内商品，查询该用户购物车剩余商品
        return this.cartService.deleteCartGoods(userId,goodsId);
    }
}
