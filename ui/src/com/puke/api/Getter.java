package com.puke.api;

import static javafx.scene.input.KeyCode.R;

/**
 * @User zijiao
 * @Version 2016/9/28
 * @Mark
 */
public interface Getter<T> extends Id {

    void post(T result);

    T getDefaultValue();

    boolean isOptional();

    String getDescription();

    GetterGroup getGroup();

}
