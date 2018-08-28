package com.ghostben.chowsangsang.excelupload.entitymapper;


import com.ghostben.chowsangsang.excelupload.viewmodels.CourseDb;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Css_CourseMapper {
    /*private String COURSE_CODE;
    private String COURSE_NAME;*/

    @Insert("insert ignore into CSS_COURSE(COURSE_CODE,COURSE_NAME) values (#{COURSE_CODE},#{COURSE_NAME})")
    public int insertCss_Course(CourseDb courseDb);

}
