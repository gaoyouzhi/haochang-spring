package com.haochang.dubbo.balance;

import com.haochang.dubbo.util.URL;

import java.util.List;
import java.util.Random;

/**
 * @description: 描述：随机调用
 * @author: youzhi.gao
 * @date: 2021-01-28 19:48
 */
public class RandomBalance {
    public URL getUrl(List<URL> list){
        Random random = new Random();
        int i = random.nextInt(list.size());
        return list.get(i);
    }
}
