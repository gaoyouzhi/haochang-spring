package com.haochang.search.mapper;

import com.haochang.search.model.EsProduct;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description: 描述：dao层
 * @author: youzhi.gao
 * @date: 2021-01-15 11:03
 */
@Mapper
@Repository
public interface EsProductMapper {

    List<EsProduct> getAllEsProductList(@Param("id") Long id);

}
