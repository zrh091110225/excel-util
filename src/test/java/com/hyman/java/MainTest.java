package com.hyman.java;

import com.hyman.java.base.ExcelView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ronghaizheng on 15/3/29.
 */
public class MainTest {
    public static void main(String[] args) throws Exception{
        List<SchoolBean> schoolBeans = new ArrayList<SchoolBean>();
        SchoolBean one = new SchoolBean("name","address",1000);
        schoolBeans.add(one);
    }
}

