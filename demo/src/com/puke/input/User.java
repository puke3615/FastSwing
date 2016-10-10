package com.puke.input;

import com.puke.getter.anno.Value;
import com.puke.getter.core.ValueType;

import static com.sun.tools.doclets.formats.html.markup.HtmlStyle.description;
import static com.sun.tools.doclint.Entity.le;

/**
 * @author zijiao
 * @version 16/10/9
 */
public class User {

    @Value(
            name = "用户名",
            description = "请输入用户名"
    )
    public String username;

    @Value(
            name = "密码",
            description = "请输入密码"
    )
    public String password;

    @Value(
            name = "年龄",
            valueType = ValueType.Integer,
            description = "请输入用户年龄"
    )
    public int age;

    @Value(
            name = "开心",
            valueType = ValueType.Boolean,
            description = "是否开心"
    )
    public boolean happy;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", happy=" + happy +
                '}';
    }
}
