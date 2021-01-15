package com.haochang.oauth2;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description: 描述：测试
 * @author: youzhi.gao
 * @date: 2020-12-30 10:26
 */
public class Test {
    public static void main(String[] args) {
        Map<String, Integer> listenerMap = new ConcurrentHashMap<>(16);

        listenerMap.putIfAbsent("aaa", 123);

        Integer a = listenerMap.computeIfAbsent("bbb", i -> new Integer(123));

        Integer b = listenerMap.computeIfAbsent("aaa", i -> new Integer(333));


    }
}
