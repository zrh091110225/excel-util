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

    @ExcelColumn(headerName = "学校名称", columnWidth = 30, columnHeight = 100)
    private String schoolName;
    @ExcelColumn(headerName = "学校地址", columnWidth = 30, columnHeight = 100)
    private String address;
    @ExcelColumn(headerName = "学校面积", columnWidth = 30, columnHeight = 100)
    private int size;
    @ExcelColumn(headerName = "创建时间", columnWidth = 30, typeHandler = DateTypeHandler.class, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @ExcelColumn(headerName = "是否211", columnWidth = 30, columnHeight = 100)
    private boolean is211;
    @ExcelColumn(headerName = "校长信息", columnWidth = 30, columnHeight = 100)
    private HeadMaster headMaster;

    public SchoolBean() {
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

    public boolean isIs211() {
        return is211;
    }

    public void setIs211(boolean is211) {
        this.is211 = is211;
    }

    public HeadMaster getHeadMaster() {
        return headMaster;
    }

    public void setHeadMaster(HeadMaster headMaster) {
        this.headMaster = headMaster;
    }
}
