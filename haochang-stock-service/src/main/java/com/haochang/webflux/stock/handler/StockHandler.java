package com.haochang.webflux.stock.handler;

import com.haochang.webflux.stock.domain.Stock;
import com.haochang.webflux.stock.repository.StockRepository;
import com.haochang.webflux.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.transaction.reactive.TransactionalOperator;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @description: 描述：库存handler
 * @author: youzhi.gao
 * @date: 2020-12-10 17:14
 */
@Component
public class StockHandler {

    @Autowired
    private StockService stockService;

    @Autowired
    private TransactionalOperator transactionalOperator;

    /**
     * 方法功能描述：根据id 获取库存
     * @MethodName: getStockById
     * @param serverRequest
     * @Return: {@link Mono<ServerResponse>}
     * @Author: yz.gao
     * @Date: 2020-12-11 9:49
     */
    public Mono<ServerResponse> getStockById(ServerRequest serverRequest){
        Long id = Long.parseLong(serverRequest.pathVariable("id"));
        return ServerResponse.ok()
                .body(stockService.getStockById(id), Stock.class)
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    /**
     * 方法功能描述：保存库存
     * @MethodName: save
     * @param serverRequest
     * @Return: {@link Mono<ServerResponse>}
     * @Author: yz.gao
     * @Date: 2020-12-11 9:50
     */
    public Mono<ServerResponse> save(ServerRequest serverRequest){
        return serverRequest.bodyToMono(Stock.class)
                .flatMap(p-> stockService.save(p))
                .flatMap(s-> ServerResponse.ok().bodyValue(s))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    /**
     * 方法功能描述：批量保存
     * @MethodName: batchSave
     * @param serverRequest
     * @Return: {@link Mono<ServerResponse>}
     * @Author: yz.gao
     * @Date: 2020-12-11 14:30
     */
    public Mono<ServerResponse> batchSave(ServerRequest serverRequest){
        return serverRequest.bodyToFlux(Stock.class)
                .flatMap(p -> stockService.save(p))
                .then(ServerResponse.ok().build())
                .as(transactionalOperator::transactional);
    }

    /**
     * 方法功能描述：根据商品id查询库存
     * @MethodName: batchSave
     * @param serverRequest
     * @Return: {@link Mono<ServerResponse>}
     * @Author: yz.gao
     * @Date: 2020-12-14 17:27
     */
    public Mono<ServerResponse> findByProductId(ServerRequest serverRequest){
        Long productId = Long.parseLong(serverRequest.pathVariable("productId"));
        return ServerResponse.ok().body(stockService.findByProductId(productId), Stock.class);
    }
}
