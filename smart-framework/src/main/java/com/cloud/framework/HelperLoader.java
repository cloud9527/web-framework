package com.cloud.framework;

import com.cloud.framework.helper.BeanHelper;
import com.cloud.framework.helper.ClassHelper;
import com.cloud.framework.helper.ControllerHelper;
import com.cloud.framework.helper.IocHelper;
import com.cloud.framework.util.ClassUtil;

/**
 * @ClassName HelperLoader
 * @Description: TODO
 * @Author: wangjing
 * @Date 2021/4/21
 * @Version V1.0
 **/
public final class HelperLoader {
    public static void init() {
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };
        for (Class<?> cls : classList) {
            ClassUtil.loadClass(cls.getName());
        }
    }
}
