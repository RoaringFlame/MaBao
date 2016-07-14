package com.mabao.repository;

import com.mabao.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User> {
    /**
     * 用户名密码获取用户信息
     * @param name              用户名
     * @param password          密码
     * @return                  用户对象
     */
    User findByNameAndPassword(String name, String password);

    /**
     * 用户名获取用户信息
     * SpringSecurity模块UserDetailsService接口使用
     * @param name              用户名
     * @return                  用户对象
     */
    User findByName(String name);

    /**
     * 通过邮箱查用户
     * @param email             邮箱
     * @return                  用户对象
     */
    User findByEmail(String email);
}
