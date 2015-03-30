package com.hyman.java.base;


/**
 * Created by ronghaizheng on 15/3/29.
 */
public abstract class TypeHandler<T> {
    public String handerType(T t) {
        return getFormat(t);
    }

    public abstract String getFormat(T t);
}
