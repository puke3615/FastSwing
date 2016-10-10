package com.puke.getter.core;

import java.util.Arrays;
import java.util.List;

/**
 * @author zijiao
 * @version 16/10/9
 */
public class GetterGroup extends Getter {
    public List<Getter> getters;

    public GetterGroup(Getter... getters) {
        this.getters = Arrays.asList(getters);
    }
}
