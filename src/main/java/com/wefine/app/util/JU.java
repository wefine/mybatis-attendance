package com.wefine.app.util;


import com.alibaba.fastjson.JSON;

import java.util.List;

public class JU {
    /**
     * list转json
     **/
    public static <T> String listToJson(List<T> t) {
        return JSON.toJSONString(t);
    }

    /**
     * 对象转json
     **/
    public static <T> String listToJson(T t) {
        return JSON.toJSONString(t);
    }
}
