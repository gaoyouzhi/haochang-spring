package com.haochang.spring.webflux.repository;

import com.haochang.spring.webflux.model.Product;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/**
 * @description: 描述：dao层
 * @author: youzhi.gao
 * @date: 2020-12-09 13:47
 */
@Repository
public interface ProductRepository extends ReactiveCrudRepository<Product, Long> {

    @Query("select * from t_product p where p.name =:name and p.category =:category")
    Flux<Product> findByNameAndCategory(String name, String category);
}
