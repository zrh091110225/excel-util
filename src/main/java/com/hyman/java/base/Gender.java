package com.hyman.java.base;

/**
 * Created by ronghaizheng on 15/4/1.
 */
public enum Gender {
    Men("男"),
    Women("女");
    String desc;

    Gender(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
