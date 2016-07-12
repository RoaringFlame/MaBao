package com.mabao.util.security;

import com.mabao.pojo.User;
import com.mabao.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * SpringSecurity模块UserDetailsService接口实现
 * 从给定的UserRepository实现中查找用户
 */
public class MaBaoUserService implements UserDetailsService {

    private final UserRepository userRepository;

    public MaBaoUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User mbuser = userRepository.findByName(username);
        if (mbuser != null){
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

            return new org.springframework.security.core.userdetails
                    .User(mbuser.getName(),mbuser.getPassword(),authorities);
        }

        throw new UsernameNotFoundException(
                "User '" + username + "' not found.");
    }
}
