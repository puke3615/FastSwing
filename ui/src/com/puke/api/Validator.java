package com.puke.api;

import static javafx.scene.input.KeyCode.T;

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
    String errorInfo(Getter data);

    Validator NOT_NULL = new Validator() {
        @Override
        public String errorInfo(Getter data) {

            return null;
        }
    };

}
