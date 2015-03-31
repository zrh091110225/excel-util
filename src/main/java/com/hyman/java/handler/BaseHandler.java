package com.hyman.java.handler;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by ronghaizheng on 15/3/30.
 */
public class BaseHandler extends TypeHandler<Object> {
    @Override
    public String handle(Object data, String pattern) {
        if (StringUtils.isBlank(pattern)) {
            if (data instanceof Integer) {
                return String.valueOf(data);
            }
            if (data instanceof String) {
                return (String) data;
            }
            if (data instanceof Boolean) {
                return String.valueOf(data);
            }
            if (data instanceof Float) {
                return String.valueOf(data);
            }
            if (data instanceof Double) {
                return String.valueOf(data);
            }
            return data.toString();
        } else {
            return data.toString();
        }
    }
}
