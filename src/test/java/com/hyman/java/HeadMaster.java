package com.hyman.java;

import com.hyman.java.annotations.ExcelColumn;

/**
 * Created by ronghaizheng on 15/4/1.
 */
public class HeadMaster {
    @ExcelColumn(headerName = "校长姓名", columnWidth = 30, columnHeight = 100)
    private String name;
    @ExcelColumn(headerName = "校长年龄", columnWidth = 30, columnHeight = 100)
    private int age;

    public HeadMaster(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
