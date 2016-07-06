package com.mabao.service;

import com.mabao.controller.vo.GoodsVO;
import com.mabao.util.PageVO;
import com.mabao.pojo.Goods;
;
import java.util.List;
import java.util.Map;


/**
 * Created by liuming on 2016/6/28.
 * 商品业务接口
 */
public interface GoodsService {
    /**
     * 新品
     * @param page
     * @param pageSize
     * @return
     */
    public List<Goods> getNewGoods(int page, int pageSize);
    /*
    *初始化页面和查询新品
     */
    public List<Goods> getGoodsListByTime(int page, int size);
    /*
   *查询搜索栏内容
    */
    public List<Goods> getGoodsListLikeTitle(String  title, int page, int size);
    /*
   *查询列表选择类型
    */
    public List<Goods> getGoodsListByTypeName(String  typeName,int page, int size);
    /*
   *查询商品详细信息
    */
    public Goods getGoodsListById(int id);
    /*
    *轮播图片列表
     */
    public List<Goods> getGoodsListByCircle();

    PageVO<GoodsVO> getPageVO(int page, int size);
    /**
     * 查询猜你喜欢
     * @param babyInfoMap
     * @param page
     * @param size
     * @return
     */
    public List<Goods> getGoodsListByTable(Map babyInfoMap, int page, int size);
    /**
     * 商品加入购物车
     * @param id
     * @return
     */
    public List<Goods> addshoppingCarGoods(int id);
    /**
     * 购物车商品列表
     * @param ids
     * @return
     */
    public List<Goods> getSelectedGoods(int[] ids);
    /**
     * 删除购物车中商品
     * @param id
     * @return
     */
    public List<Goods> deleteShoppingCarGoods(int id);

    Goods saveOne(Goods newGoods);
}
