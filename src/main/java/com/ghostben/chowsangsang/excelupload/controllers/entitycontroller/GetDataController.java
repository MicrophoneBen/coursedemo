package com.ghostben.chowsangsang.excelupload.controllers.entitycontroller;



import com.ghostben.chowsangsang.excelupload.services.DbService.CourseDbService;
import com.ghostben.chowsangsang.excelupload.viewmodels.CourseDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author ben.zhang.b.q
 * @date 25/7/2018
 */
@Controller
public class GetDataController {
    @Autowired
    CourseDbService courseDbService;

    @GetMapping(value = "/data")
    @ResponseBody
    public List<CourseDb> getCourseinfo(){
        return courseDbService.getCourseInfo();
    }

   }
