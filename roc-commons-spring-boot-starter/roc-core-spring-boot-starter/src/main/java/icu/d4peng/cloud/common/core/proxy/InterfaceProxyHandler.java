package icu.d4peng.cloud.common.core.proxy;

import icu.d4peng.cloud.common.core.exception.InvocationException;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author d4peng
 * @version 1.0.0
 * @date 2022-03-27 10:05
 * @description InterfaceProxyHandler:interface代理实现类
 */
public class InterfaceProxyHandler<T> implements InvocationHandler {
    private final Class<T> interfaceClass;

    public InterfaceProxyHandler(Class<T> interfaceClass) {
        this.interfaceClass = interfaceClass;
    }

    public T newInstance() {
        try {
            return this.interfaceClass.getConstructor().newInstance();
        } catch (Exception e) {
            throw new InvocationException(e);
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        return newInstance();
    }
}
