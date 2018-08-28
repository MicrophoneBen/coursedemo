package com.ghostben.chowsangsang.excelupload.services;

import com.ghostben.chowsangsang.excelupload.services.apiservice.CourseApi;
import com.ghostben.chowsangsang.excelupload.viewmodels.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * courseAPi 的接口实现类
 * @author ben.zhang.b.q
 * create at 25/7/2018
 */
@Service
public class CourseApiImpl implements CourseApi {
    private List<Course> courses = new ArrayList<Course>();
    @Override
    public Course saveCourse(Course newCourse) {
        // TODO Auto-generated method stub
        courses.add(newCourse);
        return newCourse;
    }
    @Override
    public List<Course> listAll() {
        // TODO Auto-generated method stub
        return courses;
    }
}
