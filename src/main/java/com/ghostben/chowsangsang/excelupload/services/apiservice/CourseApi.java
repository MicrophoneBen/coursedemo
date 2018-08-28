package com.ghostben.chowsangsang.excelupload.services.apiservice;



import com.ghostben.chowsangsang.excelupload.viewmodels.Course;

import java.util.List;

/**
 * @author ben.zhang.b.q
 * @date 31/7/2018
 */
public interface CourseApi {
    public Course saveCourse(Course newCourse);

    public List<Course> listAll();
}
