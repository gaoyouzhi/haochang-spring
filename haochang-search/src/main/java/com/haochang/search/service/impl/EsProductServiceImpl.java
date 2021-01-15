package com.haochang.search.service.impl;

import com.haochang.search.dao.EsProductDao;
import com.haochang.search.model.EsProduct;
import com.haochang.search.repository.EsProductRepository;
import com.haochang.search.service.EsProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * @description: 描述：es商品服务实现类
 * @author: youzhi.gao
 * @date: 2021-01-15 11:01
 */
@Service
public class EsProductServiceImpl implements EsProductService {


    @Autowired
    private EsProductDao esProductDao;

    @Autowired
    private EsProductRepository esProductRepository;

    @Override
    public int importAll() {
        List<EsProduct> products = esProductDao.getAllEsProductList(null);
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
        List<EsProduct> allEsProductList = esProductDao.getAllEsProductList(id);
        if(allEsProductList.size() > 0){
            EsProduct esProduct = allEsProductList.get(0);
            result = esProductRepository.save(esProduct);
        }
        return result;
    }
}
