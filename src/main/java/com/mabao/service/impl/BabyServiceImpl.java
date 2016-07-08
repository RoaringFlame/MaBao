package com.mabao.service.impl;

import com.mabao.pojo.Baby;
import com.mabao.repository.BabyRepository;
import com.mabao.service.BabyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BabyServiceImpl implements BabyService {
    @Autowired
    private BabyRepository babyRepository;

    /**
     * 添加宝宝信息
     * @param babyInfo      Baby对象
     * @return              插入的baby对象
     */
    public Baby addBaby(Baby babyInfo){
        return this.babyRepository.save(babyInfo);
    }
    /**
     * ID获取宝宝信息
     * @param babyId        宝宝ID
     * @return              宝宝对象
     */
    @Override
    public Baby getOne(Long babyId) {
        return this.babyRepository.findOne(babyId);
    }

    /**
     * 编辑宝宝信息
     * @param babyInfo              宝宝对象
     * @return                      宝宝对象
     */
    @Override
    public Baby updateBabyInfo(Baby babyInfo) {
        return null;
    }
    /**
     * 查看某用户宝宝信息
     * @param userId                    用户ID
     * @return                          宝宝list
     */
    @Override
    public List<Baby> findBabyByUserId(Long userId) {
        return null;
    }
}
