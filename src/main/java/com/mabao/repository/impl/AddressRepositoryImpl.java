package com.mabao.repository.impl;


import com.mabao.repository.custom.AddressRepositoryCustom;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
public class AddressRepositoryImpl implements AddressRepositoryCustom{
    @PersistenceContext
    private EntityManager em;

    /**    不使用JPA，自定义查询例子：  */

    /**
     * 根据JPQL查询单个对象
     * @param jpql  JPQL查询语句
     * @param args  参数
     * @param <T>   实体或者装箱基础数据类型
     * @return  单个数据对象
     */
    public<T> T findOne(String jpql,Object...args){
        Query query=em.createQuery(jpql);
        if(args!=null&&args.length>0) {
            for (int i = 0; i < args.length; i++) {
                query.setParameter(i+1, args[i]);
            }
        }
        return (T)query.getSingleResult();
    }

    /**
     * 常规JPQL查询，不分页，可以Order By
     * @param jpql JPQL查询语句
     * @param args 参数
     * @param <T> 实体
     * @return 实体集合
     */
    public<T> List<T> findAll(String jpql, Object...args){
        Query query=em.createQuery(jpql);
        if(args!=null&&args.length>0) {
            for (int i = 0; i < args.length; i++) {
                query.setParameter(i+1, args[i]);
            }
        }
        return (List<T>)query.getResultList();
    }

}
