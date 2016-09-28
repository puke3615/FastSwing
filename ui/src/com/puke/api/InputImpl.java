package com.puke.api;

import java.lang.reflect.ParameterizedType;

/**
 * @User zijiao
 * @Version 2016/9/28
 * @Mark
 */
public class InputImpl implements Input {
    @Override
    public <T> void pull(Getter<T> getter) {
        if (getter == null) {
            return;
        }

        Class cls = getter.getClass();
        Class<T> tClass = (Class<T>) ((ParameterizedType) cls.getInterfaces()[0].getGenericInterfaces()[0]).getActualTypeArguments()[0];
        T t = (T) tClass.getName();
        getter.post(t);
    }
}
