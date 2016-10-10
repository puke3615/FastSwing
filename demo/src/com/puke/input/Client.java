package com.puke.input;

import com.puke.getter.anno.ValueHandler;
import com.puke.getter.core.*;
import com.puke.getter.input.SwingFactory;

/**
 * @author zijiao
 * @version 16/10/9
 */
public class Client {

    public static void main(String[] args) {
        User user = new User();
        Getter getter = ValueHandler.resolve(user, result -> System.out.println(user));

        InputFactory factory = new SwingFactory();
        Input input = factory.createInput();
        input.pull(getter);
    }

}
