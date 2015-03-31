package com.hyman.java;

import com.hyman.java.annotations.ExcelColumn;
import com.hyman.java.annotations.ExcelTable;
import com.hyman.java.handler.DateTypeHandler;

import java.util.Date;

/**
 * Created by ronghaizheng on 15/3/29.
 */
@ExcelTable(fileName = "school")
public class SchoolBean {

    @ExcelColumn(headerName = "学校名称", columnWidth = 30)
    private String schoolName;
    @ExcelColumn(headerName = "学校地址", columnWidth = 30)
    private String address;
    @ExcelColumn(headerName = "学校面积", columnWidth = 30)
    private int size;
    @ExcelColumn(headerName = "创建时间", columnWidth = 30, typeHandler = DateTypeHandler.class, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
