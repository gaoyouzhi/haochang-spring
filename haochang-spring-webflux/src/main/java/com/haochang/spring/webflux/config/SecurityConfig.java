package com.haochang.spring.webflux.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.server.SecurityWebFilterChain;
import reactor.core.publisher.Mono;

/**
 * @description: 描述：权限管理
 * @author: youzhi.gao
 * @date: 2020-12-10 15:43
 */
@Configuration
public class SecurityConfig {


    @Bean
    public ReactiveUserDetailsService reactiveUserDetailsService(){
        UserDetails main = User.withDefaultPasswordEncoder().username("admin").password("123456").roles("ADMIN").build();
        UserDetails guest = User.withDefaultPasswordEncoder().username("guest").password("123456").roles("GUEST").build();

        return new MapReactiveUserDetailsService(main, guest);
    }


    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity serverHttpSecurity){
        return serverHttpSecurity.authorizeExchange()
                .pathMatchers(HttpMethod.POST, "/reactive/product/**")
                .hasAnyRole("ADMIN")
                .pathMatchers(HttpMethod.GET, "/reactive/product/**")
                .hasAnyRole("ADMIN")
                .pathMatchers("/route/product/**").access(((mono, object) -> mono.map(auth -> {
                    HttpMethod httpMethod = object.getExchange().getRequest().getMethod();
                    boolean granted = false;
                    if (httpMethod == HttpMethod.PUT
                            || httpMethod == HttpMethod.POST
                            || httpMethod == HttpMethod.DELETE) {
                        granted = auth.getAuthorities()
                                .stream()
                                .map(GrantedAuthority::getAuthority)
                                .anyMatch("ROLE_ADMIN"::equals);
                    } else {
                        granted = auth.isAuthenticated();
                    }
                    return (new AuthorizationDecision(granted));
                }).switchIfEmpty(Mono.justOrEmpty(new AuthorizationDecision(false)))))
                .anyExchange()
                .permitAll()
                .and()
                .httpBasic()
                .and().csrf().disable()
                .build();
    }
}
