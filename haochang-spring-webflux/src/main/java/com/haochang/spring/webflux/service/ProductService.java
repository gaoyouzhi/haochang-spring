package com.haochang.spring.webflux.service;

import com.haochang.spring.webflux.model.Product;
import com.haochang.spring.webflux.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;


/**
 * @description: 描述：商品服务
 * @author: youzhi.gao
 * @date: 2020-12-08 18:35
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public Mono<Product> save(Product product){
        return productRepository.save(product);
    }

    public Mono<Product> findById(Long id){
        return productRepository.findById(id);
    }

    public Mono<Void> deleteById(Long id){
        return productRepository.deleteById(id);
    }

    public Flux<Product> batchSave(List<Product> products){
        return productRepository.saveAll(products);
    }

}
