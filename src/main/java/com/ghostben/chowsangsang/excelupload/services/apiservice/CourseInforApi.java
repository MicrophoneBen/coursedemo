package com.ghostben.chowsangsang.excelupload.services.apiservice;



import com.ghostben.chowsangsang.excelupload.viewmodels.CourseInfor;

import java.util.List;

/**
 * @author ben.zhang.b.q
 * @date 31/7/2018
 */
public interface CourseInforApi {
     CourseInfor saveCourseInfor(CourseInfor newCourseInfor);

     List<CourseInfor> listAll();
}
