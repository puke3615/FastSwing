package com.puke.getter.core;

import java.util.ArrayList;
import java.util.List;


/**
 * @author zijiao
 * @version 16/10/9
 */
public class Validators {

    /**
     * 验证一个输入的合法性
     *
     * @param getter 输入配置及信息
     * @return 返回验证结果
     */
    public static String validate(Getter getter) {
        if (getter == null) {
            throw new RuntimeException("The getter is null.");
        }
        Object data = getter.result;
        String errorInfo = null;
        for (Validator validator : validators(getter)) {
            errorInfo = validator.errorInfo(data);
            if (errorInfo != null) {
                break;
            }
        }
        return errorInfo;
    }

    /**
     * 根据Getter配置添加对应的验证器
     *
     * @param getter getter配置
     * @return 相关的验证器列表
     */
    private static List<Validator> validators(Getter getter) {
        List<Validator> validators = new ArrayList<>();
        if (getter != null) {
            if (getter.isRequired) {
                validators.add(Validator.NOT_NULL);
            }
            switch (getter.valueType) {
                case Integer:
                    validators.add(Validator.INTEGER);
                    break;
                case Boolean:
                    validators.add(Validator.BOOLEAN);
                    break;
            }
        }
        return validators;
    }

}
