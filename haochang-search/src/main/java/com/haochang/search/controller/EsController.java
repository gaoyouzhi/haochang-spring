package com.haochang.search.controller;

import com.haochang.search.service.EsProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 描述：rest api
 * @author: youzhi.gao
 * @date: 2021-01-14 14:42
 */
@RestController
@RequestMapping("/product")
public class EsController {

    @Autowired
    private EsProductService esProductService;

    @RequestMapping("/importAll")
    public String importAll(){
        esProductService.importAll();
        return "success";
    }
}
