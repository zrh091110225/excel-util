package com.hyman.java;

import com.hyman.java.annotations.ExcelColumn;
import com.hyman.java.annotations.ExcelTable;

/**
 * Created by ronghaizheng on 15/3/29.
 */
@ExcelTable(fileName = "school")
public class SchoolBean {

    @ExcelColumn(headerName = "登录名称", columnWidth = 30)
    private String schoolName;
    private String address;
    private int size;

    public SchoolBean() {
    }

    public SchoolBean(String schoolName, String address, int size) {
        this.schoolName = schoolName;
        this.address = address;
        this.size = size;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
