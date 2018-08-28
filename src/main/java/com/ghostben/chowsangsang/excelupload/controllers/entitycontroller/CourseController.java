package com.ghostben.chowsangsang.excelupload.controllers.entitycontroller;


import com.ghostben.chowsangsang.excelupload.services.apiservice.CourseApi;
import com.ghostben.chowsangsang.excelupload.viewmodels.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ben.zhang.b.q
 * @date 26/7/2018
 */
@Controller
public class CourseController {

    @Autowired
    private CourseApi courseApi;

    @GetMapping(value = "erp/get-courses")
    public @ResponseBody
    List<Course> getCourses() {
        return courseApi.listAll();
    }

    @GetMapping(value = "/erp/count-courses")
    public @ResponseBody
    Map<String, Integer> countCourses() {
        Map<String, Integer> result = new HashMap<>();
        result.put("count", courseApi.listAll().size());
        return result;
    }
}
