package com.ghostben.chowsangsang.excelupload.viewmodels;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 与数据库连接的实体类
 * @author ben.zhang.b.q 
 * @date 
 */
@Getter
@Setter
public class CourseDb implements Serializable {
    private int COURSE_ID;
    private String COURSE_CODE;
    private String COURSE_NAME;
    private String COURSE_INST_CODE;
    private String COURSE_INST_NAME;
    private Date C_START_DTE;
    private Date C_END_DTE;
    private String C_RESULT;
    private int C_TIME;
    private String EMPL_NBR;
    /**
     *
     * 用来浏览器显示的作用
     * @author ben.zhang.b.q
     * @date 31/7/2018
     */
    private String name;

    public CourseDb() {

    }

    @Override
    public String toString() {
        return "CourseDb{" +
                "COURSE_ID=" + COURSE_ID +
                ", COURSE_CODE='" + COURSE_CODE + '\'' +
                ", COURSE_NAME='" + COURSE_NAME + '\'' +
                ", COURSE_INST_CODE='" + COURSE_INST_CODE + '\'' +
                ", COURSE_INST_NAME='" + COURSE_INST_NAME + '\'' +
                ", C_START_DTE=" + C_START_DTE +
                ", C_END_DTE=" + C_END_DTE +
                ", C_RESULT='" + C_RESULT + '\'' +
                ", C_TIME=" + C_TIME +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEMPL_NBR() {
        return EMPL_NBR;
    }

    public void setEMPL_NBR(String EMPL_NBR) {
        this.EMPL_NBR = EMPL_NBR;
    }

    public int getCOURSE_ID() {
        return COURSE_ID;
    }

    public void setCOURSE_ID(int COURSE_ID) {
        this.COURSE_ID = COURSE_ID;
    }

    public String getCOURSE_CODE() {
        return COURSE_CODE;
    }

    public void setCOURSE_CODE(String COURSE_CODE) {
        this.COURSE_CODE = COURSE_CODE;
    }

    public String getCOURSE_NAME() {
        return COURSE_NAME;
    }

    public void setCOURSE_NAME(String COURSE_NAME) {
        this.COURSE_NAME = COURSE_NAME;
    }

    public String getCOURSE_INST_CODE() {
        return COURSE_INST_CODE;
    }

    public void setCOURSE_INST_CODE(String COURSE_INST_CODE) {
        this.COURSE_INST_CODE = COURSE_INST_CODE;
    }

    public String getCOURSE_INST_NAME() {
        return COURSE_INST_NAME;
    }

    public void setCOURSE_INST_NAME(String COURSE_INST_NAME) {
        this.COURSE_INST_NAME = COURSE_INST_NAME;
    }

    public Date getC_START_DTE() {
        return C_START_DTE;
    }

    public void setC_START_DTE(Date c_START_DTE) {
        C_START_DTE = c_START_DTE;
    }

    public Date getC_END_DTE() {
        return C_END_DTE;
    }

    public void setC_END_DTE(Date c_END_DTE) {
        C_END_DTE = c_END_DTE;
    }

    public String getC_RESULT() {
        return C_RESULT;
    }

    public void setC_RESULT(String c_RESULT) {
        C_RESULT = c_RESULT;
    }

    public int getC_TIME() {
        return C_TIME;
    }

    public void setC_TIME(int c_TIME) {
        C_TIME = c_TIME;
    }

    public CourseDb(int COURSE_ID, String COURSE_CODE, String COURSE_NAME, String COURSE_INST_CODE, String COURSE_INST_NAME, Date c_START_DTE, Date c_END_DTE, String c_RESULT, int c_TIME) {
        this.COURSE_ID = COURSE_ID;
        this.COURSE_CODE = COURSE_CODE;
        this.COURSE_NAME = COURSE_NAME;
        this.COURSE_INST_CODE = COURSE_INST_CODE;
        this.COURSE_INST_NAME = COURSE_INST_NAME;
        C_START_DTE = c_START_DTE;
        C_END_DTE = c_END_DTE;
        C_RESULT = c_RESULT;
        C_TIME = c_TIME;
    }
}

