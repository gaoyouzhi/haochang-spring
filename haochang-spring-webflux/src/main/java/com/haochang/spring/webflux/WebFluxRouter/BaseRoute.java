package com.haochang.spring.webflux.WebFluxRouter;

import com.haochang.spring.webflux.WebFluxHandler.ProductHandler;
import com.haochang.spring.webflux.config.BasePath;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @description: 描述：基本路径请求
 * @author: youzhi.gao
 * @date: 2020-12-09 14:14
 */
@Configuration
public class BaseRoute {


    @Bean
    @LoadBalanced
    public RouterFunction<ServerResponse> productRoute(ProductHandler productHandler){
        return RouterFunctions.route()
                .POST(BasePath.save, productHandler::save)
                .GET(BasePath.find, productHandler::findById)
                .GET(BasePath.delete, productHandler::deleteById)
                .POST(BasePath.batchSave, productHandler::batchSave)
                .build();

    }

}
