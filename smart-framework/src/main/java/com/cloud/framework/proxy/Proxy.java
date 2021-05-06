package com.cloud.framework.proxy;

/**
 * @ClassName Proxy
 * @Description: TODO
 * @Author: wangjing
 * @Date 2021/5/6
 * @Version V1.0
 **/
public interface Proxy {

    Object doProxy(ProxyChain proxyChain) throws Throwable;
}
