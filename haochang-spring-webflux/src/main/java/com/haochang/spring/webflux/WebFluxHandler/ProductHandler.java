package com.haochang.spring.webflux.WebFluxHandler;

import com.haochang.spring.webflux.model.Product;
import com.haochang.spring.webflux.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @description: 描述：商品handler
 * @author: youzhi.gao
 * @date: 2020-12-09 11:12
 */
@Component
public class ProductHandler {

    @Autowired
    private ProductService productService;

    public Mono<ServerResponse> save(ServerRequest serverRequest){
        return serverRequest.bodyToMono(Product.class)
                .flatMap(p -> productService.save(p))
                .flatMap(p -> ServerResponse.ok().bodyValue(p));
    }

    public Mono<ServerResponse> findById(ServerRequest serverRequest){
        Long id = Long.parseLong(serverRequest.pathVariable("id"));
        return productService.findById(id)
                .flatMap(p -> ServerResponse.ok().bodyValue(p))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> deleteById(ServerRequest serverRequest){
        Long id = Long.parseLong(serverRequest.pathVariable("id"));
        return productService.findById(id)
                .flatMap(p->productService.deleteById(p.getId()).then(ServerResponse.ok().build()))
                .switchIfEmpty(ServerResponse.notFound().build());

    }
}
