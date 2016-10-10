package com.puke.getter.core;

import java.util.Collections;

/**
 * @author zijiao
 * @version 16/10/9
 */
public enum ValueType {

    Long(0),
    Integer(0),
    String(""),
    Object(null),
    Boolean(false),
    ENUM(Collections.EMPTY_LIST);

    Object defaultValue;

    ValueType(Object defaultValue) {
        this.defaultValue = defaultValue;
    }

}
