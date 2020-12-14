package com.haochang.spring.webflux.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @description: 描述：服务间调用工具类
 * @author: youzhi.gao
 * @date: 2020-12-11 14:42
 */
@Configuration
public class WebClientConfig {

    @Bean(name = "webFluxClient")
    public WebClient.Builder loadBalancedWebClientBuilder() {
        return WebClient.builder().baseUrl("http://localhost:9990");
    }
}
