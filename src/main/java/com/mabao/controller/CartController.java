package com.mabao.controller;

import com.mabao.controller.vo.CartGoodsVO;
import com.mabao.controller.vo.GoodsVO;
import com.mabao.pojo.Address;
import com.mabao.pojo.Cart;
import com.mabao.pojo.Goods;
import com.mabao.pojo.User;
import com.mabao.service.AddressService;
import com.mabao.service.CartService;
import com.mabao.util.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * 购物车模块
 * @author jackie
 */
@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private AddressService addressService;
    @RequestMapping(value = "/index",method = GET)
    public String cartIndex(){
        return "shopping";
    }

    /**
     * 添加商品到购物车
     * @param goodsId       商品ID
     * @param model         商品list
     * @return              购物车页
     */
    @RequestMapping(value = "/cartAddGoods",method = GET)
    public String shoppingCarGoodsAdd(@RequestParam Long goodsId,Model model){
        User user = UserManager.getUser();
        if (user != null){
            String result = this.cartService.addCartGoods(goodsId, user);
            model.addAttribute("result",result);
            return "detail";
        }else {
            return "login";
        }
    }

    /**
     * 查看购物车
     * @param model         商品list
     * @return              购物车页
     */
    @RequestMapping(value = "/showCart",method = GET)
    public String showUserCart(Model model){
        User user = UserManager.getUser();
        if (user != null){
            List<Cart> cartGoods = this.cartService.findAllGoodsByUser(user.getId());
            model.addAttribute("cartGoods", CartGoodsVO.generateBy(cartGoods));
            return "detail";
        }else {
            return "login";
        }
    }


    /**
     * 购物车页面提交后跳转订单确认页面
     * @param cartAndNum        <购物车ID-数量,购物车ID-数量...>格式 String
     * @param model             map(默认地址，选中支付的商品list)
     * @return                  支付页
     */
    @RequestMapping(value = "/orderConfirm",method = GET)
    public String orderConfirm(@RequestParam String cartAndNum,
                               Model model) {
        User user = UserManager.getUser();
        if (user == null) {
            return "login";
        } else {
            Map<String, Object> map = new HashMap<>();
            String[] cartAndNumArray = cartAndNum.trim().split(",");
            Map<Object, Integer> goodsAndNumMap = new HashMap<>();
            for (String one : cartAndNumArray) {
                //获得购物车ID
                Long cartId = Long.valueOf(one.trim().split("-")[0]);
                //查找商品
                Goods goods = this.cartService.get(cartId).getGoods();
                //查找对应数量
                Integer num = Integer.valueOf(one.trim().split("-")[1]);
                goodsAndNumMap.put(GoodsVO.generateBy(goods), num);
            }
            map.put("checkedGoodsMap", goodsAndNumMap);  //选中的商品列表
            Address address = this.addressService.getDefaultAddress(user.getId());
            map.put("defaultAddress", address);          //默认地址
            map.put("cartAndNum", cartAndNum);
            map.put("freight", 10);                      //运费
            model.addAllAttributes(map);
            return "pay";
        }
    }
}

