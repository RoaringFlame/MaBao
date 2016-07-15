package com.mabao.repository;

import com.mabao.pojo.Goods;
import org.springframework.data.domain.Page;
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
     * @param pageable          分页参数
     * @return                  分页goods
     */
    Page<Goods> findByTitleLikeAndState(String title, Boolean state, Pageable pageable);
    /**
     * 商品类型查询
     */
    Page<Goods> findByTypeIdAndState(Long goodsTypeId, Boolean state, Pageable pageable);

    /**
     * 商品ID集合查找商品集合
     * @param goodsIdList       商品ID集合
     * @return                  商品List
     */
    List<Goods> findByIdIn(List<Long> goodsIdList);

    /**
     * 商品查询，（商品类型，关键字）
     * @param goodsTypeId           商品类型ID
     * @param title                 关键字
     * @param pageable              分页
     * @return                      商品page
     */
    Page<Goods> findByTitleLikeAndTypeIdAndState( String title,Long goodsTypeId,Boolean state, Pageable pageable);
}
