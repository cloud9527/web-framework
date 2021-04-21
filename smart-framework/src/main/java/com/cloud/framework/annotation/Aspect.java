package com.cloud.framework.annotation;

import java.lang.annotation.*;

/**
 * @ClassName Controller
 * @Description: TODO
 * @Author: wangjing
 * @Date 2021/4/20
 * @Version V1.0
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {
    Class<? extends Annotation> value();
}
