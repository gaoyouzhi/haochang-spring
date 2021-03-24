package com.haochang.gateway.config;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * 默认降级处理
 */
//@RestController
public class DefaultHystrixController {

    private static final Log logger = LogFactory.getLog(DefaultHystrixController.class);
    @RequestMapping("/defaultFallback")
    public Map<String,String> defaultFallback(){
    	logger.info("降级操作...");
        Map<String,String> map = new HashMap<>();
        map.put("resultCode","fail");
        map.put("resultMessage","服务异常");
        map.put("resultObj","000");
        System.out.println(JSONObject.toJSONString(map));
        return map;
    }
}