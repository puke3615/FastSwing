package com.puke.api;

/**
 * @User zijiao
 * @Version 2016/9/28
 * @Mark
 */
public interface Getter<T> {

    void post(T result);

    boolean isOptional();

    String getDescription();

    String getId();

}
