package com.haochang.webflux.stock.service;

import com.haochang.webflux.stock.domain.Stock;
import com.haochang.webflux.stock.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @description: 描述：库存服务
 * @author: youzhi.gao
 * @date: 2020-12-10 17:14
 */
@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public Mono<Stock> getStockById(Long id){
        return stockRepository.findById(id);
    }

    public Mono<Stock> save(Stock stock){
        return stockRepository.save(stock);
    }
}
