package com.mabao.service;

import com.mabao.controller.vo.BabyVO;
import com.mabao.pojo.Baby;

public interface BabyService {
    /**
     * 添加宝宝信息
     * @param babyInfo      Baby对象
     * @return              插入的baby对象
     */
    Baby addBaby(BabyVO babyInfo);

    /**
     * ID获取宝宝信息
     * @param babyId        宝宝ID
     * @return              宝宝对象
     */
    Baby get(Long babyId);

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
    Baby findBabyByUserId(Long userId);

    /**
     * 保存宝宝
     * @param baby                      宝宝实体
     * @return                          宝宝
     */
    Baby saveOne(Baby baby);
    /**
     * 猜你喜欢宝宝表单（保存宝宝信息）
     * @param baby  baby对象
     * @return      babyVO对象
     */
    BabyVO guessForBabyInfo(Baby baby);
}
