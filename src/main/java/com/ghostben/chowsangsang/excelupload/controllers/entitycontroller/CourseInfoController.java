package com.ghostben.chowsangsang.excelupload.controllers.entitycontroller;

import com.ghostben.chowsangsang.excelupload.services.apiservice.CourseInforApi;
import com.ghostben.chowsangsang.excelupload.viewmodels.CourseInfor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CourseInfoController {
    @Autowired
    CourseInforApi courseInforApi;


    @RequestMapping(value="/erp/get-products", method = RequestMethod.GET)
    public @ResponseBody List<CourseInfor> getCourseInfo() {
        return courseInforApi.listAll();
    }

    @RequestMapping(value="/erp/count-products", method = RequestMethod.GET)
    public @ResponseBody Map<String, Integer> countCourseInfo() {
        Map<String, Integer> result = new HashMap<>();
        result.put("count", courseInforApi.listAll().size());
        return result;
    }

}
