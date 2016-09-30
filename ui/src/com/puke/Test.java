package com.puke;

import com.puke.api.GetterGroup;
import com.puke.api.Input;
import com.puke.api.InputFactory;
import com.puke.getter.StringGetter;

/**
 * @User zijiao
 * @Version 2016/9/28
 * @Mark
 */
public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        InputFactory factory = InputFactory.DEFAULT;
        Input input = factory.createInput();

        input.pull(new StringGetter() {
            @Override
            public void post(String result) {
                System.out.printf("输入结果是： %s", result);
            }

            @Override
            public String getDefaultValue() {
                return null;
            }

            @Override
            public boolean isOptional() {
                return true;
            }

            @Override
            public String getDescription() {
                return "输入名字： ";
            }

            @Override
            public GetterGroup getGroup() {
                return null;
            }

            @Override
            public String getId() {
                return "123";
            }
        });
    }

}
