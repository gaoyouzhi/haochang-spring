package com.haochang.spring.webflux.WebFluxHandler;

import com.haochang.spring.webflux.config.BasePath;
import com.haochang.spring.webflux.model.Product;
import com.haochang.spring.webflux.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.reactive.TransactionalOperator;
import org.springframework.web.reactive.function.client.WebClient;
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

    @Autowired
    private TransactionalOperator transactionalOperator;

    @Autowired
    @Qualifier(value = "webFluxClient")
    private WebClient.Builder webFluxClient;

    /**
     * 方法功能描述：新增商品
     * @MethodName: save
     * @param serverRequest
     * @Return: {@link Mono<ServerResponse>}
     * @Author: yz.gao
     * @Date: 2020-12-10 14:27
     */
    public Mono<ServerResponse> save(ServerRequest serverRequest){
        return serverRequest.bodyToMono(Product.class)
                .flatMap(p -> productService.save(p))
                .flatMap(p -> ServerResponse.ok().bodyValue(p));
    }

    /**
     * 方法功能描述：根据id查询商品
     * @MethodName: findById
     * @param serverRequest
     * @Return: {@link Mono<ServerResponse>}
     * @Author: yz.gao
     * @Date: 2020-12-10 14:28
     */
    public Mono<ServerResponse> findById(ServerRequest serverRequest){
        Long id = Long.parseLong(serverRequest.pathVariable("id"));
        return productService.findById(id)
                .flatMap(p -> ServerResponse.ok().bodyValue(p))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    /**
     * 方法功能描述：根据id删除
     * @MethodName: deleteById
     * @param serverRequest
     * @Return: {@link Mono<ServerResponse>}
     * @Author: yz.gao
     * @Date: 2020-12-10 14:28
     */
    public Mono<ServerResponse> deleteById(ServerRequest serverRequest){
        Long id = Long.parseLong(serverRequest.pathVariable("id"));
        return productService.findById(id)
                .flatMap(p->productService.deleteById(p.getId()).then(ServerResponse.ok().build()))
                .switchIfEmpty(ServerResponse.notFound().build());

    }

    /**
     * 方法功能描述：批量保存
     * 使用事务的两种方式
     * 1. 注解
     * 2. 手动添加事务
     * @MethodName: saveList
     * @param serverRequest
     * @Return: {@link Mono<ServerResponse>}
     * @Author: yz.gao
     * @Date: 2020-12-10 14:28
     */
//    @Transactional
    public Mono<ServerResponse> batchSave(ServerRequest serverRequest){
        return serverRequest.bodyToFlux(Product.class)
                .flatMap(p -> productService.save(p))
                .then(ServerResponse.ok().build())
                .as(transactionalOperator::transactional);
    }

    /**
     * 方法功能描述：
     * @MethodName: findById
     * @param serverRequest
     * @Return: {@link Mono<ServerResponse>}
     * @Author: yz.gao
     * @Date: 2020-12-10 16:36
     */
    public Mono<ServerResponse> findByNameAndCategory(ServerRequest serverRequest){
        String name =serverRequest.pathVariable("name");
        String category =serverRequest.pathVariable("category");
        return ServerResponse.ok().
                body(productService.findByNameAndCategory(name, category), Product.class)
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    /**
     * 方法功能描述：查询库存
     * @MethodName: findStock
     * @param serverRequest
     * @Return: {@link Mono<ServerResponse>}
     * @Author: yz.gao
     * @Date: 2020-12-14 9:30
     */
    public Mono<ServerResponse> findStock(ServerRequest serverRequest){
        Long productId = Long.parseLong(serverRequest.pathVariable("id"));
        return webFluxClient.build().get().uri(BasePath.productStockUrl + "/" +productId)
                .retrieve().bodyToMono(String.class).flatMap(p->ServerResponse.ok().bodyValue(p));
    }
}
