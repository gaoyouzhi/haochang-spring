package com.haochang.oauth2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @description: 描述：web权限认证
 * @author: youzhi.gao
 * @date: 2021-01-20 11:23
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    /**
     * 密码生成器(默认为bcrypt模式)
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.csrf().disable();
        httpSecurity.requestMatchers().antMatchers("/oauth/**","/login/**","/logout/**")
                .and()
                .authorizeRequests()
                .antMatchers("/oauth/**").authenticated()
                .and()
                .formLogin().permitAll(); //新增login form支持用户登录及授权
    }


    /**
     *授权码模式
     *http://localhost:8080/oauth/authorize?
     response_type=code&client_id=client&redirect_uri=http://www.baidu.com&scope=all
     *http://localhost:8080/oauth/authorize?
     response_type=code&client_id=client
     *
     * password模式
     * http://localhost:8080/oauth/token?
     username=fox&password=123456&grant_type=password&client_id=client&client_secret=
     123123&scope=all
     *
     * 客户端模式
     * http://localhost:8080/oauth/token?
     grant_type=client_credentials&scope=all&client_id=client&client_secret=123123
     */

}