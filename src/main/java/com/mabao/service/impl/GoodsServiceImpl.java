package com.mabao.service.impl;

import com.mabao.enums.Gender;
import com.mabao.pojo.Baby;
import com.mabao.pojo.Goods;
import com.mabao.pojo.User;
import com.mabao.repository.BabyRepository;
import com.mabao.repository.GoodsRepository;
import com.mabao.repository.UserRepository;
import com.mabao.service.BabyService;
import com.mabao.service.GoodsService;
import com.mabao.service.UserService;
import com.mabao.util.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsRepository goodsRepository;
    @Autowired
    private BabyService babyService;
    @Autowired
    private UserService userService;

    /**
     * 新品
     */
    @Override
    public Page<Goods> getNewGoods(int page, int pageSize) {
        return this.goodsRepository.findAll(new PageRequest(page, pageSize));
    }

    /**
     * 首页商品模糊搜索
     */
    @Override
    public Page<Goods> goodsSearch(Long goodsTypeId,String title, int page, int pageSize) {
        if (goodsTypeId == null && (title == null || "".equals(title))){
            return this.goodsRepository.findByState(Boolean.TRUE,new PageRequest(page, pageSize));
        }if (goodsTypeId != null && title != null && !"".equals(title)){
            return this.goodsRepository.findByTypeIdAndStateAndTitleLike(goodsTypeId,Boolean.TRUE,title,new PageRequest(page, pageSize));
        }else if (title == null || "".equals(title)){
            return this.goodsRepository.findByTypeIdAndState(goodsTypeId,Boolean.TRUE,new PageRequest(page, pageSize));
        }else if (goodsTypeId == null){
            return this.goodsRepository.findByStateAndTitleLike(Boolean.TRUE,title,new PageRequest(page, pageSize));
        }else {
            return null;
        }

    }
    /**
     * 查询商品信息
     */
    @Override
    public Goods get(Long goodsId) {
        return this.goodsRepository.findOne(goodsId);
    }

    /**
     * （首页猜你喜欢）
     * @param page              页码
     * @param pageSize          一页大小
     * @return                  商品集合，分页
     */
    @Override
    public Page<Goods> goodsListGuess(Baby baby, int page, int pageSize) {
        User user = UserManager.getUser();
        if (user != null){
            baby.setUser(this.userService.get(user.getId()));
            this.babyService.saveOne(baby);
        }
        return this.goodsRepository.findByState(Boolean.TRUE,new PageRequest(page, pageSize));
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
    public List<Goods> findGoodsByIdIn(List<Long> goodsIdList) {
        return this.goodsRepository.findByIdIn(goodsIdList);
    }

    /**
     * 依据宝宝ID匹配商品
     * （首页猜你喜欢）
     * @param babyId                宝宝ID
     * @param page                  页码
     * @param pageSize              一页大小
     * @return                      商品集合，分页
     */
    @Override
    public Page<Goods> goodsPageByBabyId(Long babyId, int page, int pageSize) {
        return this.goodsRepository.findByState(Boolean.TRUE,new PageRequest(page, pageSize));
    }
}
