package com.puke.getter.input;

import com.puke.getter.core.Getter;
import com.puke.getter.core.IResult;
import com.puke.getter.core.Input;
import com.puke.getter.core.InputFactory;

import java.util.Scanner;

/**
 * @author zijiao
 * @version 16/10/9
 */
public class CommandFactory implements InputFactory {

    public static void main(String[] args) {
        Getter getter = new Getter();
        getter.name = "名称";
        getter.description = "描述文字";
        getter.callback = result -> System.out.println("结果是: " + result);

        InputFactory factory = new CommandFactory();
        Input input = factory.createInput();
        input.pull(getter);
    }

    @Override
    public Input createInput() {
        return new CommandInput();
    }

    private class CommandInput implements Input {
        @Override
        public void pull(Getter getter) {
            Scanner scanner = new Scanner(System.in);
            System.out.print(getter.description + ": ");
            String input = scanner.next();
            getter.callback.onResult(input);
        }
    }


}
