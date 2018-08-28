package com.ghostben.chowsangsang.excelupload.services.DbService;


import com.ghostben.chowsangsang.excelupload.entitymapper.Css_Course_AttdMapper;
import com.ghostben.chowsangsang.excelupload.viewmodels.CourseInfoDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Css_Course_AttdService  implements Css_Course_AttdMapper {
    @Autowired
    Css_Course_AttdMapper css_course_attdMapper;

    @Override
    public int insertCss_Course_Attd(CourseInfoDb courseInfoDb) {
        return css_course_attdMapper.insertCss_Course_Attd(courseInfoDb);
    }
}
