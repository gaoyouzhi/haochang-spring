package com.haochang.webflux.stock.route;

import com.haochang.webflux.stock.config.BasePath;
import com.haochang.webflux.stock.handler.StockHandler;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;


/**
 * @description: 描述：库存系统路由
 * @author: youzhi.gao
 * @date: 2020-12-10 17:14
 */
@Component
public class StockRoute {

    @Bean
    @LoadBalanced
    public RouterFunction<ServerResponse> stockRouting(StockHandler stockHandler){
        return RouterFunctions.route()
                .POST(BasePath.save, stockHandler::save)
                .GET(BasePath.find, stockHandler::getStockById).build();
    }

}
