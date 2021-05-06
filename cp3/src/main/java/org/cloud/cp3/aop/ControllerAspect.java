package org.cloud.cp3.aop;

import com.cloud.framework.annotation.Aspect;
import com.cloud.framework.annotation.Controller;
import com.cloud.framework.proxy.AspectProxy;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;

/**
 * @ClassName ControllerAspect
 * @Description: TODO
 * @Author: wangjing
 * @Date 2021/5/6
 * @Version V1.0
 **/
@Aspect(Controller.class)
@Slf4j
public class ControllerAspect extends AspectProxy {
    private long begin;

    @Override
    public void before(Class<?> targetClass, Method targetMethod, Object[] methodParams) {
        log.debug("---begin----");
        log.debug(String.format("class:%s", targetClass.getName()));
        log.debug(String.format("mehotd:%s", targetMethod.getName()));
        begin = System.currentTimeMillis();
    }

    @Override
    public void after(Class<?> targetClass, Method targetMethod, Object[] methodParams) {
        log.debug(String.format("time:%dms", System.currentTimeMillis() - begin));
        log.debug("---end----");
    }
}
