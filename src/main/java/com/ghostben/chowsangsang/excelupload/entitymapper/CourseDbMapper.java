package com.ghostben.chowsangsang.excelupload.entitymapper;


import com.ghostben.chowsangsang.excelupload.viewmodels.CourseDb;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 这是mybatis的mapper接口 数据对数据库操作的入口接口
 * @author ben.zhang.b.q
 * @date 25/7/2018
 */
@Mapper
public interface CourseDbMapper {
    //insert ignore
    //replace

    /**
     * insertCourse 插入数据到数据库
     * @date
     * @param courseDb
     * @return
     */
    @Insert("insert ignore into SOP_COURSE(COURSE_CODE,COURSE_NAME," +
            "COURSE_INST_CODE,COURSE_INST_NAME,C_START_DTE,C_END_DTE,C_RESULT,C_TIME) values" +
            "(#{COURSE_CODE},#{COURSE_NAME},#{COURSE_INST_CODE},#{COURSE_INST_NAME}," +
            "#{C_START_DTE},#{C_END_DTE},#{C_RESULT},#{C_TIME})")
     int insertCourse(CourseDb courseDb);


    @Select("Select * from SOP_COURSE")
     List<CourseDb> getCourseInfo();
}
