package com.ghostben.chowsangsang.excelupload.viewmodels;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.*;

/**
 * @author ben.zhang.b.q
 * @date  26/7/2018
 */
@Getter
@Setter
public class CourseInfor {
    private String error;
    private String tags;
    private String token;
    private String sku;
    private double rating;
    private String vendor;
    private int status = 0;
    private int visibility = 0;
    private long position;
    private Date createdAt;
    private Date updatedAt;
    // format 2017-05-03 03:46:13
    private String type;
    private List<String> links = new ArrayList<>();
    private static Random random = new Random();
    private Map<String, String> attributes = new HashMap<>();

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public static CourseInfor createAlert(String errorMessage) {
        CourseInfor courseInfor = new CourseInfor();
        return courseInfor.alert(errorMessage);
    }

    public CourseInfor alert(String errorMessage) {
        error = errorMessage;
        return this;
    }

    private Integer Employee_No;
    //进入数据库
    private String Employee_Name;
    private String Section;
    private String Department;
    private String Title;
    private String Course_Code;
    private String Course_Name;
    private String Course_Instant_Code;
    private String Course_Instant_Name;
    private Date Start_Date;
    private Date End_Date;
    private String Result;
    private  int Time;
    /**
     * name Browser 傳輸數據時候的提示信息
     */
    private String name;


    public CourseInfor(Integer employee_No, String employee_Name, String section, String department, String title, String course_Code, String course_Name, String course_Instant_Code, String course_Instant_Name, Date start_Date, Date end_Date, String result, int time) {
        Employee_No = employee_No;
        Employee_Name = employee_Name;
        Section = section;
        Department = department;
        Title = title;
        Course_Code = course_Code;
        Course_Name = course_Name;
        Course_Instant_Code = course_Instant_Code;
        Course_Instant_Name = course_Instant_Name;
        Start_Date = start_Date;
        End_Date = end_Date;
        Result = result;
        Time = time;
    }

    @Override
    public String toString() {
        return "CourseInfor{" +
                "Employee_No=" + Employee_No +
                ", Employee_Name='" + Employee_Name + '\'' +
                ", Section='" + Section + '\'' +
                ", Department='" + Department + '\'' +
                ", Title='" + Title + '\'' +
                ", Course_Code='" + Course_Code + '\'' +
                ", Course_Name='" + Course_Name + '\'' +
                ", Course_Instant_Code='" + Course_Instant_Code + '\'' +
                ", Course_Instant_Name='" + Course_Instant_Name + '\'' +
                ", Start_Date=" + Start_Date +
                ", End_Date=" + End_Date +
                ", Result='" + Result + '\'' +
                ", Time=" + Time +
                '}';
    }

    public CourseInfor() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse_Code() {
        return Course_Code;
    }

    public void setCourse_Code(String course_Code) {
        Course_Code = course_Code;
    }

    public String getCourse_Name() {
        return Course_Name;
    }

    public void setCourse_Name(String course_Name) {
        Course_Name = course_Name;
    }

    public String getCourse_Instant_Code() {
        return Course_Instant_Code;
    }

    public void setCourse_Instant_Code(String course_Instant_Code) {
        Course_Instant_Code = course_Instant_Code;
    }

    public String getCourse_Instant_Name() {
        return Course_Instant_Name;
    }

    public void setCourse_Instant_Name(String course_Instant_Name) {
        Course_Instant_Name = course_Instant_Name;
    }

    public Date getStart_Date() {
        return Start_Date;
    }

    public void setStart_Date(Date start_Date) {
        Start_Date = start_Date;
    }

    public Date getEnd_Date() {
        return End_Date;
    }

    public void setEnd_Date(Date end_Date) {
        End_Date = end_Date;
    }

    public String getResult() {
        return Result;
    }

    public void setResult(String result) {
        Result = result;
    }

    public int getTime() {
        return Time;
    }

    public void setTime(int time) {
        Time = time;
    }

    public Integer getEmployee_No() {
        return Employee_No;
    }

    public void setEmployee_No(Integer employee_No) {
        Employee_No = employee_No;
    }

    public String getEmployee_Name() {
        return Employee_Name;
    }

    public void setEmployee_Name(String employee_Name) {
        Employee_Name = employee_Name;
    }

    public String getSection() {
        return Section;
    }

    public void setSection(String section) {
        Section = section;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
