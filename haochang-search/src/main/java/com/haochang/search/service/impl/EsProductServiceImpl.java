package com.haochang.search.service.impl;

import com.haochang.search.mapper.EsProductMapper;
import com.haochang.search.model.EsProduct;
import com.haochang.search.repository.EsProductRepository;
import com.haochang.search.service.EsProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * @description: 描述：es商品服务实现类
 * @author: youzhi.gao
 * @date: 2021-01-15 11:01
 */
@Service
public class EsProductServiceImpl implements EsProductService {


    @Autowired
    private EsProductMapper esProductMapper;

    @Autowired
    private EsProductRepository esProductRepository;

    @Override
    public int importAll() {
        List<EsProduct> products = esProductMapper.getAllEsProductList(null);
        Iterable<EsProduct> productIterable = esProductRepository.saveAll(products);
        Iterator<EsProduct> iterator = productIterable.iterator();
        int result = 0;
        while (iterator.hasNext()){
            result++;
            iterator.next();
        }
        return result;
    }

    @Override
    public EsProduct create(Long id) {
        EsProduct result = null;
        List<EsProduct> allEsProductList = esProductMapper.getAllEsProductList(id);
        if(allEsProductList.size() > 0){
            EsProduct esProduct = allEsProductList.get(0);
            result = esProductRepository.save(esProduct);
        }
        return result;
    }

    @Override
    public EsProduct findById(Long id) {
        return esProductRepository.findById(id).get();

    }
}
