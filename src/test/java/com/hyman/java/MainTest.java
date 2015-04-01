package com.hyman.java;

import com.hyman.java.export.ExportUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ronghaizheng on 15/3/29.
 */
public class MainTest {
    public static void main(String[] args) throws Exception {
        List<SchoolBean> schoolBeans = new ArrayList<SchoolBean>();
        SchoolBean one = new SchoolBean();
        one.setAddress("北京");
        one.setCreateTime(new Date());
        one.setSchoolName("hit");
        one.setIs211(true);
        one.setSize(10000);
        schoolBeans.add(one);
        ExportUtil.export("schoolInfo", schoolBeans);
    }
}

