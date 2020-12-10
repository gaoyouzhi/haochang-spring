package com.haochang.webflux.stock.handler;

import com.haochang.webflux.stock.domain.Stock;
import com.haochang.webflux.stock.repository.StockRepository;
import com.haochang.webflux.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @description: 描述：库存handler
 * @author: youzhi.gao
 * @date: 2020-12-10 17:14
 */
@Configuration
public class StockHandler {

    @Autowired
    private StockService stockService;

    public Mono<ServerResponse> getStockById(ServerRequest serverRequest){
        Long id = Long.parseLong(serverRequest.pathVariable("id"));
        return ServerResponse.ok()
                .body(stockService.getStockById(id), Stock.class)
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> save(ServerRequest serverRequest){
        return serverRequest.bodyToMono(Stock.class).flatMap(p-> stockService.save(p))
                .flatMap(s-> ServerResponse.ok().bodyValue(s))
                .switchIfEmpty(ServerResponse.notFound().build());
    }
}
