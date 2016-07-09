package com.mabao.service;

import com.mabao.controller.vo.GoodsVO;
import com.mabao.enums.Gender;
import com.mabao.util.PageVO;
import com.mabao.pojo.Goods;
import org.springframework.data.domain.Page;
;
import java.util.List;

/**
 * Created by liuming on 2016/6/28.
 * 商品业务接口
 */
public interface GoodsService {
    /**
     * 新品
     */
    Page<Goods> getNewGoods(int page, int pageSize);

    /**
    * 首页商品模糊搜索
    */
    Page<Goods> goodsSearch(String title, int page, int pageSize);

    /**
    * 商品类型查询
    */
    Page<Goods> findGoodsByGoodsType(Long goodsTypeId, int page, int pageSize);
    /**
     * 查询商品详细信息
     * @param goodsId           商品ID
    */
    Goods get(Long goodsId);
    /**
      * 轮播图片列表
     */
    List<Goods> getGoodsPictureCircle();

    /**
     * （首页猜你喜欢）
     * @param babyName          宝宝姓名
     * @param babyBirthday      宝宝生日
     * @param gender            宝宝性别
     * @param hobby             爱好
     * @param page              页码
     * @param pageSize          一页大小
     * @return                  商品集合，分页
     */
    Page<Goods> goodsListGuess(String babyName, String babyBirthday, Gender gender, String hobby, int page, int pageSize);

    /**
     * 保存商品
     * @param newGoods        商品对象，需包含用户ID
     * @return                保存的商品对象
     */
    Goods saveOne(Goods newGoods);

    /**
     * 根据商品ID查商品list
     * @param goodsIdList           商品ID集合
     * @return                      商品list
     */
    List<Goods> findGoodsByIdIn(List<Long> goodsIdList);

}
