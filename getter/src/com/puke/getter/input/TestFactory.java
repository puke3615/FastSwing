package com.puke.getter.input;

import com.puke.getter.core.Getter;
import com.puke.getter.core.Input;
import com.puke.getter.core.InputFactory;

/**
 * @author zijiao
 * @version 16/10/9
 */
public class TestFactory implements InputFactory {
    @Override
    public Input createInput() {
        return new TestInputImpl();
    }

    private class TestInputImpl implements Input {

        @Override
        public void pull(Getter getter) {
            getter.callback.onResult("make a test.");
        }
    }

}
