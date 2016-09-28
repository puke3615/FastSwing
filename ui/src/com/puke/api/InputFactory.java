package com.puke.api;

/**
 * @User zijiao
 * @Version 2016/9/28
 * @Mark
 */
public interface InputFactory {

    InputFactory DEFAULT = new InputFactory() {
        @Override
        public Input createInput() {
            return new InputImpl();
        }
    };

    Input createInput();

}
