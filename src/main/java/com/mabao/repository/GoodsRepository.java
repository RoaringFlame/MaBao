package com.mabao.repository;

import com.mabao.pojo.Goods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsRepository extends BaseRepository<Goods> {
    /**
     * 上架商品
     * @param state             是否上架
     * @param pageable          分页参数
     * @return                  分页goods
     */
    Page<Goods> findByState(Boolean state, Pageable pageable);

    /**
     * 依据标题模糊查询
     * @param title             标题key
     * @param pageable       分页参数
     * @return                  分页goods
     */
    Page<Goods> findByTitleLike(String title, Pageable pageable);
    /**
     * 商品类型查询
     */
    Page<Goods> findByTypeId(Long typeId, Pageable pageable);

    /**
     * 商品ID集合查找商品集合
     * @param goodsIdList       商品ID集合
     * @return                  商品List
     */
    List<Goods> findByIdIn(List<Integer> goodsIdList);
}
