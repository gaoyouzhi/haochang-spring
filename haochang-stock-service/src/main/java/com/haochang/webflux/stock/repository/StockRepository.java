package com.haochang.webflux.stock.repository;

import com.haochang.webflux.stock.domain.Stock;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

/**
 * @description: 描述：库存dao层
 * @author: youzhi.gao
 * @date: 2020-12-10 17:34
 */
@Component
public interface StockRepository extends ReactiveCrudRepository<Stock, Long> {

    @Query("select * from t_stock where product_id=:productId")
    public Flux<Stock> findByProductId(Long productId);

}
