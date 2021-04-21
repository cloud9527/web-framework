package com.cloud.framework.bean;

import com.cloud.framework.util.CastUtil;
import com.cloud.framework.util.ClassUtil;

import java.util.Map;

/**
 * @ClassName Param
 * @Description: TODO
 * @Author: wangjing
 * @Date 2021/4/21
 * @Version V1.0
 **/
public class Param {

    private Map<String, Object> paramMap;

    public Param(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    public Long getLong(String name) {
        return CastUtil.castLong(paramMap.get(name));
    }

    public Map<String, Object> getMap() {
        return paramMap;
    }
}
