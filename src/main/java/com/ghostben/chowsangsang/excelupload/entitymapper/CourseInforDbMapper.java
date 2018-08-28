package com.ghostben.chowsangsang.excelupload.entitymapper;

import com.ghostben.chowsangsang.excelupload.viewmodels.CourseInfoDb;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author ben.zhang.b.q
 * @date 26/7/2018
 */
@Mapper
public interface CourseInforDbMapper {

    @Insert("insert into SOP_EMPL(COURSE_CODE,COURSE_NAME," +
            "COURSE_INST_CODE,COURSE_INST_NAME,C_START_DTE,C_END_DTE,C_RESULT,C_TIME,EMPL_NBR,EMPL_NAM,EMPL_SEC,EMPL_DEPT,EMPL_TIT) values" +
            "(#{COURSE_CODE},#{COURSE_NAME},#{COURSE_INST_CODE},#{COURSE_INST_NAME}," +
            "#{C_START_DTE},#{C_END_DTE},#{C_RESULT},#{C_TIME},#{EMPL_NBR},#{EMPL_NAM},#{EMPL_SEC},#{EMPL_DEPT},#{EMPL_TIT})")
    int insertCourseInfoDb(CourseInfoDb courseInfoDb);


    @Select("Select * from SOP_EMPL")
    List<CourseInfoDb> getCourseInfoDb();

}
