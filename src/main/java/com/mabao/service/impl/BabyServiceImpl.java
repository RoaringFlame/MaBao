package com.mabao.service.impl;

import com.mabao.controller.vo.BabyVO;
import com.mabao.pojo.Baby;
import com.mabao.pojo.User;
import com.mabao.repository.BabyRepository;
import com.mabao.service.BabyService;
import com.mabao.util.UserManager;
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
    public Baby addBaby(BabyVO babyInfo){
        User user = UserManager.getUser();
        assert (user != null):"用户为空null";
        List<Baby> babyList = this.babyRepository.findByUserId(user.getId());
        if (babyList.size()>0){
            return null;
        }else {
            Baby newBaby = new Baby();
            newBaby.setName(babyInfo.getName());
            newBaby.setUser(UserManager.getUser());
            newBaby.setBirthday(babyInfo.getBirthday());
            newBaby.setGender(babyInfo.getGender());
            newBaby.setHobby(babyInfo.getHobby());
            return this.babyRepository.save(newBaby);
        }
    }
    /**
     * ID获取宝宝信息
     * @param babyId        宝宝ID
     * @return              宝宝对象
     */
    @Override
    public Baby get(Long babyId) {
        return this.babyRepository.findOne(babyId);
    }

    /**
     * 编辑宝宝信息
     * @param babyInfo              宝宝对象
     * @return                      宝宝对象
     */
    @Override
    public Baby updateBabyInfo(Baby babyInfo) {
        return this.babyRepository.saveAndFlush(babyInfo);
    }
    /**
     * 查看某用户宝宝信息
     * @param userId                    用户ID
     * @return                          宝宝list
     */
    @Override
    public List<Baby> findBabyByUserId(Long userId) {
        List<Baby> babyList =  this.babyRepository.findByUserId(userId);
        if (babyList.size()>0){
            return babyList;
        }else {
            return null;
        }
    }

    /**
     * 保存宝宝
     * @param baby                      宝宝实体
     * @return                          宝宝
     */
    @Override
    public Baby saveOne(Baby baby) {
        return this.babyRepository.save(baby);
    }
}
