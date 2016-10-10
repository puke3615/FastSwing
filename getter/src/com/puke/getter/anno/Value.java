package com.puke.getter.anno;

import com.puke.getter.core.ValueType;

import java.lang.annotation.*;

import static com.sun.tools.doclint.Entity.nu;

/**
 * @author zijiao
 * @version 16/10/9
 *          Getter的注解支持
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Value {

    String id() default "";

    String name();

    ValueType valueType() default ValueType.String;

    boolean isRequired() default true;

    String description() default "";

    String defaultValue() default "";

}
