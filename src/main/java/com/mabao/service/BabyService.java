package com.mabao.service;

import com.mabao.controller.vo.BabyVO;
import com.mabao.pojo.Baby;

import java.util.List;

public interface BabyService {
    /**
     * 添加宝宝信息
     * @param babyInfo      Baby对象
     * @return              插入的baby对象
     */
    Baby addBaby(Baby babyInfo);

    /**
     * ID获取宝宝信息
     * @param babyId        宝宝ID
     * @return              宝宝对象
     */
    Baby getOne(Long babyId);

    /**
     * 编辑宝宝信息
     * @param babyInfo              宝宝对象
     * @return                      宝宝对象
     */
    Baby updateBabyInfo(Baby babyInfo);

    /**
     * 查看某用户宝宝信息
     * @param userId                    用户ID
     * @return                          宝宝list
     */
    List<Baby> findBabyByUserId(Long userId);
}
