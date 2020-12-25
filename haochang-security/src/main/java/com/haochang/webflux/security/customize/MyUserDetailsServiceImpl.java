package com.haochang.webflux.security.customize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


/**
 * @description: 描述：自定义用户信息
 * @author: youzhi.gao
 * @date: 2020-12-23 11:18
 */
@Service
public class MyUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String encoderPassword = bCryptPasswordEncoder.encode("123456");
        UserDetails userDetails = User.withUsername("admin")
                .password(encoderPassword)
                .authorities("admin").build();
//        UserDetails userDetails = User.withUsername("admin")
//                .password("{noop}123456")
//                .authorities("admin").build();
        return userDetails;
    }
}
