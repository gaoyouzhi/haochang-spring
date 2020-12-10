package com.haochang.webflux.stock.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


/**
 * @description: 描述：库存
 * @author: youzhi.gao
 * @date: 2020-12-10 17:11
 */
@Table("t_stock")
public class Stock {

    @Id
    private Long id;

    private Long productId;

    private Long amount;

    private String name;

    public Stock() {
    }

    public Stock(Long id, Long productId, Long amount, String name) {
        this.id = id;
        this.productId = productId;
        this.amount = amount;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
