package com.hyman.java.handler;

import com.hyman.java.base.Gender;

/**
 * Created by ronghaizheng on 15/4/1.
 */
public class GenderHandler extends TypeHandler<Gender> {

    @Override
    public String handle(Object date, String pattern) {
        return ((Gender) date).getDesc();
    }
}
