package com.haochang.webflux.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @description: 描述：库存启动类
 * @author: youzhi.gao
 * @date: 2020-12-09 18:25
 */
@SpringBootApplication
@EnableTransactionManagement
public class StockApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockApplication.class, args);
    }
}
