package com.haochang.dubbo.regist;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 描述：本地注册缓存
 * @author: youzhi.gao
 * @date: 2021-01-28 15:29
 */
public class LocalRegister {
    public static Map<String, Class> map = new HashMap<String, Class>();

    public static Class get(String name) {
        return map.get(name);
    }

    public static void register(String name, Class implClass){
        map.putIfAbsent(name, implClass);
    }
}
