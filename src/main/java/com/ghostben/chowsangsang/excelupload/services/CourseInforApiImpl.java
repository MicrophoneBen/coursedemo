package com.ghostben.chowsangsang.excelupload.services;


import com.ghostben.chowsangsang.excelupload.services.apiservice.CourseInforApi;
import com.ghostben.chowsangsang.excelupload.viewmodels.CourseInfor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseInforApiImpl implements CourseInforApi {
    private List<CourseInfor> courseInfors = new ArrayList<>();

    @Override
    public CourseInfor saveCourseInfor(CourseInfor newCourseInfor) {
        courseInfors.add(newCourseInfor);
        return newCourseInfor;
    }

    @Override
    public List<CourseInfor> listAll() {
        return courseInfors;
    }
}
