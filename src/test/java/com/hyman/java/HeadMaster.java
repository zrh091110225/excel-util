package com.hyman.java;

import com.hyman.java.annotations.ExcelColumn;
import com.hyman.java.base.Gender;
import com.hyman.java.handler.GenderHandler;

/**
 * Created by ronghaizheng on 15/4/1.
 */
public class HeadMaster {
    @ExcelColumn(headerName = "校长姓名", columnWidth = 30, columnHeight = 100)
    private String name;
    @ExcelColumn(headerName = "校长年龄", columnWidth = 30, columnHeight = 100)
    private int age;
    @ExcelColumn(headerName = "校长性别", columnWidth = 30, columnHeight = 100, typeHandler = GenderHandler.class)
    private Gender gender;

    public HeadMaster(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
