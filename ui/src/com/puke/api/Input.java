package com.puke.api;

/**
 * @User zijiao
 * @Version 2016/9/28
 * @Mark
 */
public interface Input {

    <T> void pull(Getter<T> getter);

}
