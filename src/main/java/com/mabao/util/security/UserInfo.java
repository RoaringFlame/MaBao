package com.mabao.util.security;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class UserInfo extends User {
    private static final long serialVersionUID = 1L;

    private Long userId;

    public UserInfo(String username, String password,Collection<GrantedAuthority> authorities)
            throws IllegalArgumentException {
        super(username,password,authorities);
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}