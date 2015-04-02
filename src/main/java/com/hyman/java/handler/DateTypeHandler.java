package com.hyman.java.handler;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

import java.util.Date;

/**
 * Created by ronghaizheng on 15/3/30.
 */
public class DateTypeHandler extends TypeHandler<Date> {
    private final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";

    //TODO 添加日期格式的校验
    @Override
    public String handle(Object date, String pattern) {
        if (date == null){
            return StringUtils.EMPTY;
        }
        String receivePattern = DEFAULT_DATE_PATTERN;
        if (StringUtils.isNotBlank(pattern)) receivePattern = pattern;
        DateTime dateTime = new DateTime(((Date)date).getTime());
        return dateTime.toString(receivePattern);
    }
}
