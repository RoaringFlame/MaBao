package com.mabao.controller.rest;

import com.mabao.controller.vo.CartGoodsVO;
import com.mabao.controller.vo.JsonResultVO;
import com.mabao.pojo.Cart;
import com.mabao.pojo.User;
import com.mabao.service.CartService;
import com.mabao.util.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


@RestController
@RequestMapping(value = "/cart")
public class CartRESTController {
    @Autowired
    private CartService cartService;

    /**
     * 添加商品到购物车
     * @param goodsId       商品ID
     * @return              购物车页
     */
    @RequestMapping(value = "/cartAddGoods",method = RequestMethod.GET)
    public JsonResultVO shoppingCarGoodsAdd(@RequestParam Long goodsId){
        return this.cartService.addCartGoods(goodsId);
    }

    /**
     * 查看购物车
     * @return              购物车页
     */
    @RequestMapping(value = "/showCart",method = RequestMethod.GET)
    public List<CartGoodsVO> showUserCart(){
        User user = UserManager.getUser();
        if (user != null) {
            List<Cart> cartGoods = this.cartService.findAllGoodsByUser(user.getId());
            return CartGoodsVO.generateBy(cartGoods);
        }else {
            throw new NullPointerException();
        }
    }

    /**
     * 修改购物车内某商品数量
     * @param cartId        购物车ID
     * @param opt           操作：1加2减
     * @param num           数量
     * @return              JsonResultVO
     */
    @RequestMapping(value = "/changeNum/{cartId}",method = RequestMethod.GET)
    public JsonResultVO changeCartGoodsNum(@PathVariable Long cartId,
                                           @RequestParam Integer opt,
                                           @RequestParam(required = false,defaultValue = "1") Integer num){
        return this.cartService.changeCartGoodsNum(cartId,opt,num);
    }

    /**
     * 删除购物车内商品
     * @param cartId            购物车ID
     * @return                  结果VO
     */
    @RequestMapping(value = "/deleteGoods/{cartId}", method = RequestMethod.DELETE)
    public JsonResultVO deleteShoppingCartGoods(@PathVariable Long cartId) {
        return this.cartService.deleteCartGoods(cartId);
    }
}
