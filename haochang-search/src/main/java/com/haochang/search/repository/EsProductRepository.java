package com.haochang.search.repository;

import com.haochang.search.model.EsProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @description: 描述：es操作工具类
 * @author: youzhi.gao
 * @date: 2021-01-14 14:43
 */
@Repository
public interface EsProductRepository extends ElasticsearchRepository<EsProduct, Long> {


    Page<EsProduct> findByNameOrSubTitleOrKeywords(String name, String subTitle, String keywords, Pageable page);

}
