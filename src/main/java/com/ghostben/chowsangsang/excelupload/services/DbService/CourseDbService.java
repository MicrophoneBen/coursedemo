package com.ghostben.chowsangsang.excelupload.services.DbService;


import com.ghostben.chowsangsang.excelupload.entitymapper.CourseDbMapper;
import com.ghostben.chowsangsang.excelupload.viewmodels.CourseDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseDbService implements CourseDbMapper {
    @Autowired
    CourseDbMapper courseDbMapper;

    @Override
    public int insertCourse(CourseDb courseDb) {
        return courseDbMapper.insertCourse(courseDb);
    }

    @Override
    public List<CourseDb> getCourseInfo() {
        return courseDbMapper.getCourseInfo();
    }
}
