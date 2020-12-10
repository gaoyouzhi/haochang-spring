package com.haochang.webflux.stock.repository;

import com.haochang.webflux.stock.domain.Stock;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Component;

/**
 * @description: 描述：库存dao层
 * @author: youzhi.gao
 * @date: 2020-12-10 17:34
 */
@Component
public interface StockRepository extends ReactiveCrudRepository<Stock, Long> {


}
