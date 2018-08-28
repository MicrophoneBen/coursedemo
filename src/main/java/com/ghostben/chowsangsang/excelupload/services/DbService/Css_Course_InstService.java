package com.ghostben.chowsangsang.excelupload.services.DbService;


import com.ghostben.chowsangsang.excelupload.entitymapper.Css_Course_InstMapper;
import com.ghostben.chowsangsang.excelupload.viewmodels.CourseDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Css_Course_InstService implements Css_Course_InstMapper {
    @Autowired
    Css_Course_InstMapper css_course_instMapper;

    @Override
    public int insertCss_Course_Inst(CourseDb courseDb) {
        return css_course_instMapper.insertCss_Course_Inst(courseDb);
    }
}
