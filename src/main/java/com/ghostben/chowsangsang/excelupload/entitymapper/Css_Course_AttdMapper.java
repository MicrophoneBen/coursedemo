package com.ghostben.chowsangsang.excelupload.entitymapper;


import com.ghostben.chowsangsang.excelupload.viewmodels.CourseInfoDb;
import com.ghostben.chowsangsang.excelupload.viewmodels.CourseInfor;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Css_Course_AttdMapper {
    @Insert("insert into Css_Course_Attd(COURSE_INST_CODE,EMPL_NBR,C_RESULT) values" +
            "(#{COURSE_INST_CODE},#{EMPL_NBR},#{C_RESULT})")
    public int insertCss_Course_Attd(CourseInfoDb courseInfoDb);
}
