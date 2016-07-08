package com.mabao.repository;

import com.mabao.pojo.User;
import com.sun.org.apache.xpath.internal.operations.String;
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
}
