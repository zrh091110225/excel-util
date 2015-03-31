package com.hyman.java.handler;


/**
 * Created by ronghaizheng on 15/3/29.
 */
public abstract class TypeHandler<T> {
    public String handerType(T t, String pattern) {
        return handle(t, pattern);
    }

    public abstract String handle(T t, String pattern);
}
