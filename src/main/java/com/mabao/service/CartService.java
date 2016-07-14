package com.mabao.service;

import com.mabao.controller.vo.JsonResultVO;
import com.mabao.pojo.Cart;
import com.mabao.pojo.User;

import java.util.List;

/**
 * 购物车业务接口
 * Created by jackie on 2016/07/06.
 */
public interface CartService {

    /**
     * 删除购物车内商品
     * @param cartId           购物车ID
     * @return                  结果VO
     */
    JsonResultVO deleteCartGoods(Long cartId);
    /**
     * 用户购物车中商品列表
     * @return                  商品list
     */
    List<Cart> findAllGoodsByUser(Long userId);

    /**
     * get一条购物车信息
     * @param cartId            购物车ID
     * @return                  购物车对象
     */
    Cart get(Long cartId);

    /**
     * 检测商品是否在购物车内
     * @param goodsId           商品ID
     * @return                  购物车
     */
    Cart findByGoodsId(Long goodsId);

    /**
     * 更新购物车信息
     * @param cart              购物车
     * @return                  更新的购物车
     */
    Cart updateCart(Cart cart);

    /**
     * 购物车添加商品
     * @param goodsId       商品ID
     * @param user          用户
     * @return              结果String
     */
    String addCartGoods(Long goodsId, User user);
    /**
     * 修改购物车内某商品数量
     * @param cartId        购物车ID
     * @param opt           操作：1加2减
     * @param num           数量
     * @return              JsonResultVO
     */
    JsonResultVO changeCartGoodsNum(Long cartId, Integer opt, Integer num);
}
