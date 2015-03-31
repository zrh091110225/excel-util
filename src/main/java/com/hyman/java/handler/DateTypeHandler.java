package com.hyman.java.handler;

import org.joda.time.DateTime;

import java.util.Date;

/**
 * Created by ronghaizheng on 15/3/30.
 */
public class DateTypeHandler extends TypeHandler<Date> {
    @Override
    public String handle(Date date, String pattern) {
        //check
        DateTime dateTime = new DateTime();
        return dateTime.toString(pattern);
    }
}
