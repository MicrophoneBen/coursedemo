package com.ghostben.chowsangsang.excelupload.viewmodels;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Course {
    private String error;

    private String tags;

    private String token;

    private String sku;

    private double rating;
    private int course_id;
    private String Course_Code;
    private String Course_Name;
    private String Course_Instant_Code;
    private String Course_Instant_Name;
    private Date start_Date;
    private Date end_Date;
    private String result;
    private int time;
    private String name;


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


    private String vendor;

    private int status = 0;

    private int visibility = 0;

    private long position;

    private Date createdAt;

    private Date updatedAt; // format 2017-05-03 03:46:13

    private String type;

    private List<String> links = new ArrayList<>();

    private static Random random = new Random();

    //private List<Double> prices = new ArrayList<>();
    private Map<String, String> attributes = new HashMap<>();

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Date getStart_Date() {
        return start_Date;
    }

    public void setStart_Date(Date start_Date) {
        this.start_Date = start_Date;
    }

    public Date getEnd_Date() {
        return end_Date;
    }

    public void setEnd_Date(Date end_Date) {
        this.end_Date = end_Date;
    }

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

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Course() {

    }

    public Course(String vendor, int course_id, String sku, Date start_Date, Date end_Date,
                  Map<String, String> properties, String result, int time, String tags) {
        this.course_id = course_id;
        this.vendor = vendor;
        this.sku = sku;
        this.result = result;
        this.start_Date = start_Date;
        this.time = time;
        this.end_Date = end_Date;
        this.attributes = properties;
        this.result = result;
        this.rating = random.nextInt(3) + 2;
        this.tags = tags;
    }

    public static Course createAlert(String errorMessage) {
        Course course = new Course();
        return course.alert(errorMessage);
    }

    public Course alert(String errorMessage) {
        error = errorMessage;
        return this;
    }

    @Override
    public String toString() {
        return "Course{" +
                "error='" + error + '\'' +
                ", tags='" + tags + '\'' +
                ", token='" + token + '\'' +
                ", sku='" + sku + '\'' +
                ", rating=" + rating +
                ", vendor='" + vendor + '\'' +
                ", status=" + status +
                ", visibility=" + visibility +
                ", position=" + position +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", type='" + type + '\'' +
                ", links=" + links +
                '}';
    }

    public String CoursetoString() {
        return "Course{" +
                "course_id='" + course_id + '\'' +
                ", time=" + time +
                ", result='" + result + '\'' +
                ", start_Date=" + start_Date +
                ", end_Date=" + end_Date +
                ", attributes=" + attributes +
                '}';
    }
}

