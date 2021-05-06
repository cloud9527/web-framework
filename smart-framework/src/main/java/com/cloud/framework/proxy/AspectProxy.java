package com.cloud.framework.proxy;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * @ClassName AspectProxy
 * @Description: TODO
 * @Author: wangjing
 * @Date 2021/5/6
 * @Version V1.0
 **/
@Slf4j
public abstract class AspectProxy implements Proxy {

    @Override
    public Object doProxy(ProxyChain proxyChain) throws Throwable {
        Object result = null;
        Class<?> targetClass = proxyChain.getTargetClass();
        Method targetMethod = proxyChain.getTargetMethod();
        Object[] methodParams = proxyChain.getMethodParams();
        begin();
        try {
            if (intercept(targetClass, targetMethod, methodParams)) {
                before(targetClass, targetMethod, methodParams);
                result = proxyChain.doProxyChain();
                after(targetClass, targetMethod, methodParams);
            } else {
                result = proxyChain.doProxyChain();
            }
        } catch (Exception e) {
            log.error("proxy failure", e);
            error(targetClass, targetMethod, methodParams, e);
            throw e;
        } finally {
            end();

        }
        return result;
    }

    public void after(Class<?> targetClass, Method targetMethod, Object[] methodParams) {

    }

    public void before(Class<?> targetClass, Method targetMethod, Object[] methodParams) {

    }

    public boolean intercept(Class<?> targetClass, Method targetMethod, Object[] methodParams) {
        return true;
    }

    public void end() {
    }

    public void error(Class<?> targetClass, Method targetMethod, Object[] methodParams, Throwable e) {

    }

    public void begin() {

    }
}
