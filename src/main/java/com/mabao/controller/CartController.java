package com.mabao.controller;

import com.mabao.controller.vo.AddressVO;
import com.mabao.controller.vo.CartGoodsVO;
import com.mabao.pojo.Address;
import com.mabao.pojo.Cart;
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
     * 购物车页面提交后跳转订单确认页面
     * @param cartIds           <购物车ID,购物车ID...>格式 String
     * @param model             map(默认地址，选中支付的商品list)
     * @return                  支付页
     */
    @RequestMapping(value = "/orderConfirm",method = GET)
    public String orderConfirm(@RequestParam String cartIds,
                               Model model) {
        User user = UserManager.getUser();
        if (user == null) {
            return "login";
        } else {
            Map<String, Object> map = new HashMap<>();
            String[] cartArray = cartIds.trim().split(",");
            List<Cart> cartList = new ArrayList<>();
            Double totalSum = 0.0;
            for (String one : cartArray) {
                //获得购物车ID
                Long cartId = Long.valueOf(one);
                //查找商品
                Cart cart = this.cartService.get(cartId);
                totalSum =totalSum +(cart.getGoods().getPrice()*cart.getQuantity());
                cartList.add(cart);
            }
            Address address = this.addressService.getDefaultAddress(user.getId());
            map.put("defaultAddress", address !=null ? AddressVO.generateBy(address) : null);           //默认地址
            map.put("checkedGoodsList", CartGoodsVO.generateBy(cartList));                              //选中的商品列表
            map.put("freight", 10);                                                                     //运费
            map.put("totalSum",totalSum+10);                                                            //总计价格
            map.put("cartIds",cartIds);
            model.addAllAttributes(map);
            return "pay";
        }
    }
}

