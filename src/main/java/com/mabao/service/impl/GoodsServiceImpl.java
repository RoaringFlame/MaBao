package com.mabao.service.impl;

import com.mabao.controller.vo.GoodsVO;
import com.mabao.enums.Gender;
import com.mabao.util.PageVO;
import com.mabao.pojo.Goods;
import com.mabao.repository.GoodsRepository;
import com.mabao.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements GoodsService {


    @Autowired
    private GoodsRepository goodsRepository;

    /**
     * 新品（初始化）
     */
    @Override
    public List<Goods> getNewGoods(int page, int pageSize) {
        return null;
    }

    /**
     * 首页商品模糊搜索
     */
    @Override
    public List<Goods> goodsSearch(String title, int page, int size) {
        return null;
    }
    /**
     * 商品类型查询
     */
    @Override
    public List<Goods> getGoodsListByTypeName(String typeName, int page, int size) {
        return null;
    }
    /**
     * 查询商品详细信息
     */
    @Override
    public Goods getGoodsById(int id) {
        return null;
    }
    /**
     * 轮播图片列表
     */
    @Override
    public List<Goods> getGoodsPictureCircle() {
        return null;
    }
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
    @Override
    public PageVO<GoodsVO> goodsListGuess(String babyName, String babyBirthday, Gender gender, String hobby, int page, int pageSize) {
        return null;
    }
    /**
     * 保存商品
     * @param newGoods        商品对象，需包含用户ID
     * @return                保存的商品对象
     */
    @Override
    public Goods saveOne(Goods newGoods) {
        return null;
    }
}
