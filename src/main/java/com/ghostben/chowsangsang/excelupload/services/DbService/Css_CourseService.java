package com.ghostben.chowsangsang.excelupload.services.DbService;


import com.ghostben.chowsangsang.excelupload.entitymapper.Css_CourseMapper;
import com.ghostben.chowsangsang.excelupload.viewmodels.CourseDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Microphoneben
 * @date 2/8/2018
 */
@Service
public class Css_CourseService implements Css_CourseMapper {
    @Autowired
    Css_CourseMapper css_courseMapper;

    @Override
    public int insertCss_Course(CourseDb courseDb) {
        return css_courseMapper.insertCss_Course(courseDb);
    }
}
