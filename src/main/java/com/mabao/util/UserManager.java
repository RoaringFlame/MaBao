package com.mabao.util;

import com.mabao.pojo.User;
import com.mabao.util.security.UserInfo;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserManager {

    /**
     * 获取当前用户
     * @return User
     */
    public static User getUser() {
        try {
            UserInfo userInfo = (UserInfo) SecurityContextHolder
                    .getContext().getAuthentication().getPrincipal();
            User user = new User();
            user.setId(userInfo.getUserId());
            user.setName(userInfo.getUsername());
            user.setPassword(userInfo.getPassword());
            user.setPhone(userInfo.getPhone());
            user.setPicture(userInfo.getPicture());
            user.setEmail(userInfo.getEmail());
            user.setCreateTime(userInfo.getCreateTime());
            return user;
        }catch (Exception e){
            return null;
        }

    }
}
