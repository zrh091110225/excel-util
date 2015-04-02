package com.hyman.java;

import com.hyman.java.base.ExcelView;
import com.hyman.java.utils.ExportUtil;
import org.springframework.web.servlet.ModelAndView;

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
        SchoolBean two = new SchoolBean();
        two.setAddress("上海");
        two.setCreateTime(new Date());
        two.setSchoolName("qc");
        two.setIs211(true);
        two.setSize(20000);
        schoolBeans.add(one);
        schoolBeans.add(two);
        ModelAndView modelAndView = new ModelAndView(new ExcelView<SchoolBean>(schoolBeans));
    }
}

