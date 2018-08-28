package com.ghostben.chowsangsang.excelupload.entitymapper;

import com.ghostben.chowsangsang.excelupload.viewmodels.CourseDb;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Css_Course_InstMapper {

    @Insert("insert ignore into CSS_COURSE_INST(COURSE_INST_CODE,COURSE_CODE,COURSE_INST_NAME,C_START_DTE,C_END_DTE,C_TIME)values" +
            "(#{COURSE_INST_CODE},#{COURSE_CODE},#{COURSE_INST_NAME},#{C_START_DTE},#{C_END_DTE},#{C_TIME})")
    public int insertCss_Course_Inst(CourseDb courseDb);

}
