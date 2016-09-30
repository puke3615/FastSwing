package com.puke.api;

import java.util.List;

/**
 * @author zijiao
 * @version 16/9/29
 *          Mark
 */
public interface GetterGroup extends Getter<Object> {

    List<Getter<?>> get();

    Getter get(int position);

    void add(Getter<?> getter);

    void remove();

}
