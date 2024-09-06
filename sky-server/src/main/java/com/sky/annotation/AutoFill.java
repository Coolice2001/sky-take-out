package com.sky.annotation;

import com.sky.enumeration.OperationType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author：Coolice
 * @date：Created in 2024/9/4 18:04
 * @description：自定义注解，用于标识某个方法需要进行功能字段自动填充处理
 * @modified By：
 * @version:$
 */
@SuppressWarnings({"all"})
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoFill {
    //指定数据库操作类型:INSERT UPDATE
    OperationType value();
}

