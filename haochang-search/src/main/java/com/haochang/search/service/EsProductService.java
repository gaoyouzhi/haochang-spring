package com.haochang.search.service;

import com.haochang.search.model.EsProduct;

import java.util.List;

/**
 * @description: 描述：es服务
 * @author: youzhi.gao
 * @date: 2021-01-14 14:40
 */
public interface EsProductService {

    int importAll();

    EsProduct create(Long id);
}
