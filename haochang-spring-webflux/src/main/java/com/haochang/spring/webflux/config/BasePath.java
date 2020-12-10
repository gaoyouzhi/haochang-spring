package com.haochang.spring.webflux.config;

/**
 * @description: 描述：基本路径
 * @author: youzhi.gao
 * @date: 2020-12-09 14:17
 */
public class BasePath {
    public static final String root = "/reactive";
    public static final String productRoot = "/reactive/product";

    public static final String save = productRoot + "/save";
    public static final String delete = productRoot + "/delete/id/{id}";
    public static final String update = productRoot + "/update/id{id}";
    public static final String find = productRoot + "/find/id/{id}";
    public static final String batchSave = productRoot + "/batchSave";
    public static final String findByNameAndCategory = productRoot + "/findByNameAndCategory/name/{name}/category/{category}";


}
