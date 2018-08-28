package com.ghostben.chowsangsang.excelupload.services.DbService;

import com.ghostben.chowsangsang.excelupload.entitymapper.CourseInforDbMapper;
import com.ghostben.chowsangsang.excelupload.viewmodels.CourseInfoDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseInfoDbService implements CourseInforDbMapper {
    @Autowired
    CourseInforDbMapper courseInforDbMapper;

    @Override
    public int insertCourseInfoDb(CourseInfoDb courseInfoDb) {
        return courseInforDbMapper.insertCourseInfoDb(courseInfoDb);
    }

    @Override
    public List<CourseInfoDb> getCourseInfoDb() {
        return courseInforDbMapper.getCourseInfoDb();
    }
}
