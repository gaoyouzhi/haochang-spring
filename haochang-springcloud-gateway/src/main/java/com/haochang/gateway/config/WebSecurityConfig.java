package com.haochang.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.reactive.config.EnableWebFlux;

/**
 * @description: 描述：不开启授权
 * @author: youzhi.gao
 * @date: 2021-03-23 15:28
 */
@Configuration
@EnableWebFlux
public class WebSecurityConfig {

    @Bean
    public SecurityWebFilterChain webFluxSecurityFilterChain(ServerHttpSecurity http) throws Exception {

        http.authorizeExchange()
                .anyExchange()
                .permitAll();

        //一些配置
        http.csrf().disable()
                .httpBasic().disable()
                .logout().disable()
                .formLogin().disable();
        return http.build();
    }
}
