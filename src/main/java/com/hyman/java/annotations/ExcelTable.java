package com.hyman.java.annotations;

import java.lang.annotation.*;

/**
 * Created by ronghaizheng on 15/3/29.
 */
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelTable {
    /**
     * Excel文件名
     */
    String fileName();

    /**
     * 文件最大行数
     */
    int maxRows() default 65535;
}
