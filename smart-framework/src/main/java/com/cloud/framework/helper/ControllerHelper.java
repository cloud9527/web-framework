package com.cloud.framework.helper;

import com.cloud.framework.annotation.Action;
import com.cloud.framework.bean.Handler;
import com.cloud.framework.bean.Request;
import com.cloud.framework.util.ArrayUtil;
import com.cloud.framework.util.CollectionUtil;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName ControllerHelper
 * @Description: TODO
 * @Author: wangjing
 * @Date 2021/4/21
 * @Version V1.0
 **/
public final class ControllerHelper {

    private static final Map<Request, Handler> ACTION_MAP = new HashMap<Request, Handler>();

    static {
        Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
        if (CollectionUtil.isNotEmpty(controllerClassSet)) {
            for (Class<?> controllerClass : controllerClassSet) {
                Method[] declaredMethods = controllerClass.getDeclaredMethods();
                if (ArrayUtil.isNotEmpty(declaredMethods)) {
                    for (Method declaredMethod : declaredMethods) {
                        if (declaredMethod.isAnnotationPresent(Action.class)) {
                            Action action = declaredMethod.getAnnotation(Action.class);
                            String mapping = action.value();
                            if (mapping.matches("\\w+:/\\w*")) {
                                String[] split = mapping.split(":");
                                if (ArrayUtil.isNotEmpty(split) && split.length == 2) {
                                    String requestMethod = split[0];
                                    String requestPath = split[1];
                                    Request request = new Request(requestMethod, requestPath);
                                    Handler handler = new Handler(controllerClass, declaredMethod);
                                    ACTION_MAP.put(request, handler);
                                }
                            }

                        }
                    }
                }
            }
        }
    }

    /**
     * 获取 Handler
     */
    public static Handler getHandler(String requestMethod, String requestPath) {
        Request request = new Request(requestMethod, requestPath);
        return ACTION_MAP.get(request);
    }

}
