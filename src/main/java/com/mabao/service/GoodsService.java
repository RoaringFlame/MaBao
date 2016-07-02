package com.mabao.service;

import com.mabao.controller.vo.GoodsVO;
import com.mabao.controller.vo.PageVO;
import com.mabao.pojo.Goods;
import org.springframework.data.domain.Page;
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

    List<Goods> getGoodsListByTable(Map<String, String> babyInfoMap, int page, int size);
}
