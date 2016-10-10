package com.puke.getter.anno;

import com.puke.getter.core.Getter;
import com.puke.getter.core.GetterGroup;
import com.puke.getter.core.IResult;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zijiao
 * @version 16/10/9
 *          Value注解解析器
 */
public class ValueHandler {

    public static GetterGroup resolve(Object obj, IResult completeCallback) {
        if (obj == null) {
            throw new NullPointerException("The obj is null.");
        }
        Class cls = obj.getClass();
        List<Getter> getters = new ArrayList<>();
        while (cls != null && cls != Object.class) {
            for (Field field : cls.getDeclaredFields()) {
                addGetter(field, getters, obj);
            }
            cls = cls.getSuperclass();
        }
        GetterGroup group = new GetterGroup();
        group.getters = getters;
        group.callback = completeCallback;
        return group;
    }

    private static void addGetter(final Field field, List<Getter> getters, final Object obj) {
        if (!field.isAnnotationPresent(Value.class)) {
            return;
        }
        Value v = field.getAnnotation(Value.class);

        Getter getter = new Getter();
        getter.id = v.id();
        if ("".equals(getter.id)) {
            getter.id = field.getName();
        }
        getter.name = v.name();
        getter.valueType = v.valueType();
        getter.isRequired = v.isRequired();
        getter.description = v.description();
        getter.result = v.defaultValue();
        getter.callback = result -> {
            field.setAccessible(true);
            try {
                switch (getter.valueType) {
                    case Integer:
                        result = Integer.parseInt(result.toString());
                        break;
                    case Long:
                        result = Long.parseLong(result.toString());
                        break;
                    case Boolean:
                        result = Boolean.parseBoolean(result.toString());
                        break;
                }
                field.set(obj, result);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        };

        getters.add(getter);
    }

}
