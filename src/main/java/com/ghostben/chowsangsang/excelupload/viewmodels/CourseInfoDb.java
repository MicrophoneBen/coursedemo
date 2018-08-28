package com.ghostben.chowsangsang.excelupload.viewmodels;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class CourseInfoDb implements Serializable {
    private String COURSE_CODE;
    private String COURSE_NAME;
    private String COURSE_INST_CODE;
    private String COURSE_INST_NAME;
    private Date C_START_DTE;
    private Date C_END_DTE;
    private String C_RESULT;
    private int C_TIME;
    private String EMPL_NBR;
    private String EMPL_NAM;
    private String EMPL_SEC;
    private String EMPL_DEPT;
    private String EMPL_TIT;

    public CourseInfoDb(String COURSE_CODE, String COURSE_NAME, String COURSE_INST_CODE, String COURSE_INST_NAME, Date c_START_DTE, Date c_END_DTE, String c_RESULT, int c_TIME, String EMPL_NBR, String EMPL_NAM, String EMPL_SEC, String EMPL_DEPT, String EMPL_TIT) {
        this.COURSE_CODE = COURSE_CODE;
        this.COURSE_NAME = COURSE_NAME;
        this.COURSE_INST_CODE = COURSE_INST_CODE;
        this.COURSE_INST_NAME = COURSE_INST_NAME;
        C_START_DTE = c_START_DTE;
        C_END_DTE = c_END_DTE;
        C_RESULT = c_RESULT;
        C_TIME = c_TIME;
        this.EMPL_NBR = EMPL_NBR;
        this.EMPL_NAM = EMPL_NAM;
        this.EMPL_SEC = EMPL_SEC;
        this.EMPL_DEPT = EMPL_DEPT;
        this.EMPL_TIT = EMPL_TIT;
    }

    @Override
    public String toString() {
        return "CourseInfoDb{" +
                ", COURSE_CODE='" + COURSE_CODE + '\'' +
                ", COURSE_NAME='" + COURSE_NAME + '\'' +
                ", COURSE_INST_CODE='" + COURSE_INST_CODE + '\'' +
                ", COURSE_INST_NAME='" + COURSE_INST_NAME + '\'' +
                ", C_START_DTE=" + C_START_DTE +
                ", C_END_DTE=" + C_END_DTE +
                ", C_RESULT='" + C_RESULT + '\'' +
                ", C_TIME=" + C_TIME +
                ", EMPL_NBR=" + EMPL_NBR +
                ", EMPL_NAM='" + EMPL_NAM + '\'' +
                ", EMPL_SEC='" + EMPL_SEC + '\'' +
                ", EMPL_DEPT='" + EMPL_DEPT + '\'' +
                ", EMPL_TIT='" + EMPL_TIT + '\'' +
                '}';
    }
    public CourseInfoDb() {
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

    public String getEMPL_NBR() {
        return EMPL_NBR;
    }

    public void setEMPL_NBR(String EMPL_NBR) {
        this.EMPL_NBR = EMPL_NBR;
    }

    public String getEMPL_NAM() {
        return EMPL_NAM;
    }

    public void setEMPL_NAM(String EMPL_NAM) {
        this.EMPL_NAM = EMPL_NAM;
    }

    public String getEMPL_SEC() {
        return EMPL_SEC;
    }

    public void setEMPL_SEC(String EMPL_SEC) {
        this.EMPL_SEC = EMPL_SEC;
    }

    public String getEMPL_DEPT() {
        return EMPL_DEPT;
    }

    public void setEMPL_DEPT(String EMPL_DEPT) {
        this.EMPL_DEPT = EMPL_DEPT;
    }

    public String getEMPL_TIT() {
        return EMPL_TIT;
    }

    public void setEMPL_TIT(String EMPL_TIT) {
        this.EMPL_TIT = EMPL_TIT;
    }
}
