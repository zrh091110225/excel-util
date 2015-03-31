package com.hyman.java.annotations;

import com.hyman.java.handler.BaseHandler;
import com.hyman.java.handler.TypeHandler;

import java.lang.annotation.*;

/**
 * Created by ronghaizheng on 15/3/29.
 */
@Inherited
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelColumn {
    /**
     * 列标题
     */
    public String headerName();

    /**
     * 列宽度
     */
    public int columnWidth() default 15;

    /**
     * 列高度
     */
    public int columnHeight() default 5;

    /**
     * 字段格式
     */
    public String pattern() default "";

    /**
     * 类型处理器
     */
    Class<? extends TypeHandler<?>> typeHandler() default BaseHandler.class;
}
