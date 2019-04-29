package com.deer.wms.project.seed.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description:定义自定义注解，拦截controller 1、RetentionPolicy.SOURCE *
 * 注解只保留在源文件中，在编译成class文件的时候被遗弃 2、RetentionPolicy.CLASS
 * 注解被保留在class中，但是在jvm加载的时候北欧抛弃，这个是默认的声明周期 3、RetentionPolicy.RUNTIME
 * 注解在jvm加载的时候仍被保留
 * 
 * @author gtt
 * @date 2019年1月17日
 * @version 1.0
 */
@Retention(RetentionPolicy.RUNTIME) // 元注解，定义注解被保留策略，一般有三种策略
@Target({ ElementType.METHOD }) // 定义了注解声明在哪些元素之前
@Documented
public @interface OperateLog {

	// 定义成员
	String description() default ""; // 描述

	String type() default ""; // 操作的类型，1、添加 2、修改 3、删除 4、查询

	String notes() default ""; // 备注
}
