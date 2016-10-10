package com.puke.getter.core;

/**
 * @author zijiao
 * @version 16/9/29
 *          数据校验
 */
public interface Validator {

    /**
     * @param data 待校验的数据
     * @return null: 校验通过  or: 未通过,返回错误信息
     */
    String errorInfo(Object data);

    Validator NOT_NULL = data -> data == null || "".equals(data) ? "输入信息不能为空" : null;

    Validator INTEGER = data -> {
        try {
            Integer.parseInt(data.toString());
            return null;
        } catch (Exception e) {
            return "输入必须为int型数据";
        }
    };

    Validator BOOLEAN = data -> "true".equals(data) || "false".equals(data) ? null : "输入必须为boolean型数据";

}
