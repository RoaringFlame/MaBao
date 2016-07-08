package com.mabao.service.impl;

import com.mabao.controller.vo.GoodsVO;
import com.mabao.enums.Gender;
import com.mabao.util.PageVO;
import com.mabao.pojo.Goods;
import com.mabao.repository.GoodsRepository;
import com.mabao.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsRepository goodsRepository;

    /**
     * 新品（初始化）
     */
    @Override
    public PageVO<GoodsVO> getNewGoods(int page, int pageSize) {
        Page<Goods> goodsPage = this.goodsRepository.findAll(new PageRequest(page, pageSize));
        PageVO<GoodsVO> voPage = new PageVO<>();
        voPage.toPage(goodsPage);
        voPage.setItems(GoodsVO.generateBy(goodsPage.getContent()));
        return voPage;
    }

    /**
     * 首页商品模糊搜索
     */
    @Override
    public Page<Goods> goodsSearch(String title, int page, int pageSize) {
        return this.goodsRepository.findByTitleLike(title,new PageRequest(page, pageSize));
    }
    /**
     * 商品类型查询
     */
    @Override
    public Page<Goods> findGoodsByGoodsType(Long goodsTypeId, int page, int pageSize) {
        return this.goodsRepository.findByGoodsTypeId(goodsTypeId,new PageRequest(page, pageSize));
    }
    /**
     * 查询商品信息
     */
    @Override
    public Goods get(Long goodsId) {
        return this.goodsRepository.findOne(goodsId);
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
    public Page<Goods> goodsListGuess(String babyName, String babyBirthday, Gender gender, String hobby, int page, int pageSize) {
        return null;
    }
    /**
     * 保存商品
     * @param newGoods        商品对象，需包含用户ID
     * @return                保存的商品对象
     */
    @Override
    public Goods saveOne(Goods newGoods) {
        return this.goodsRepository.save(newGoods);
    }
    /**
     * 根据商品ID查商品list
     * @param goodsIdList           商品ID集合
     * @return                      商品list
     */
    @Override
    public List<Goods> findGoodsByIdIn(List<Integer> goodsIdList) {
        return this.goodsRepository.findByIdIn(goodsIdList);
    }
}
