package com.ghostben.chowsangsang.excelupload.controllers;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ghostben.chowsangsang.excelupload.services.DbService.CourseDbService;
import com.ghostben.chowsangsang.excelupload.services.DbService.Css_CourseService;
import com.ghostben.chowsangsang.excelupload.services.DbService.Css_Course_AttdService;
import com.ghostben.chowsangsang.excelupload.services.DbService.Css_Course_InstService;
import com.ghostben.chowsangsang.excelupload.services.apiservice.CourseApi;
import com.ghostben.chowsangsang.excelupload.utils.DataRow;
import com.ghostben.chowsangsang.excelupload.utils.DataTable;
import com.ghostben.chowsangsang.excelupload.utils.ExcelTable;
import com.ghostben.chowsangsang.excelupload.viewmodels.Course;
import com.ghostben.chowsangsang.excelupload.viewmodels.CourseDb;
import com.ghostben.chowsangsang.excelupload.viewmodels.UploadEvent;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.*;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;


@Controller
public class UploadCourseExcelController {

    ThreadFactory nThreadFactory = new ThreadFactoryBuilder().setNameFormat("Demo-pool-%d").build();
    ExecutorService threadpool = new ThreadPoolExecutor(5, 20, Long.MAX_VALUE ,TimeUnit.MILLISECONDS,
    new LinkedBlockingQueue<Runnable> (1024), nThreadFactory, new AbortPolicy());

    private ListeningExecutorService executor = MoreExecutors.listeningDecorator(threadpool);

    private static final Logger logger = LoggerFactory.getLogger(UploadCourseExcelController.class);

    @Autowired
    CourseApi courseApi;
    @Autowired
    CourseDbService courseDbService;
    @Autowired
    Css_CourseService css_courseService;
    @Autowired
    Css_Course_InstService css_course_instService;
    @Autowired
    Css_Course_AttdService css_course_attdService;

    @Autowired
    private SimpMessagingTemplate brokerMessagingTemplate;

    private String getVendor(String token) {
        return "vendor";
    }


    @RequestMapping(value = "/erp/upload-course-excel", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> uploadProductCsv(@RequestParam("file") MultipartFile file,
                                         //在csv 中做的处理，所以还是要处理这个模块
                                         @RequestParam("token") String token) throws ServletException, IOException {
        logger.info("upload-excel invoked.");

        Map<String, Object> result = new HashMap<>();
        //result部分，对读取结果的一种记录

        final String label = UUID.randomUUID().toString() + ".xlsx";
        final String filepath = "/tmp/" + label;
        byte[] bytes = file.getBytes();
        File fh = new File("/tmp/");
        if (!fh.exists()) {
            fh.mkdir();
        }

        try {
            FileOutputStream writer = new FileOutputStream(filepath);
            writer.write(bytes);
            writer.close();

            logger.info("image bytes received: {}", bytes.length);

            executor.submit(() -> {
                try {
                    UploadEvent event = new UploadEvent();
                    event.setState("Uploaded filed received on server");
                    event.setEventType("start");
                    brokerMessagingTemplate.convertAndSend("/topics/event",
                            JSON.toJSONString(event, SerializerFeature.BrowserCompatible));

                    final FileInputStream inputStream = new FileInputStream(filepath);
                    DataTable table = ExcelTable.load(() -> inputStream);
                    inputStream.close();     //读入Excel文件之后关闭输入流
                    int rowCount = table.rowCount();
                    //从输入流中得到行数目，然后进行处理
                    for (int i = 0; i < rowCount; ++i) {
                        DataRow row = table.row(i);
                        String Course_id = row.cell("Course_id");
                        String Course_Code = row.cell("Course_Code");
                        String Course_Name = row.cell("Course_Name");
                        String Course_Instant_Code = row.cell("Course_Instant_Code");
                        String Course_Instant_Name = row.cell("Course_Instant_Name");
                        String Start_Date = row.cell("Start_Date");
                        String End_Date = row.cell("End_Date");
                        //这里的字段与上文重复，更名grade，即结果
                        String grade = row.cell("Result");
                        String Time = row.cell("Time");


                        SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd");
                        Course course = new Course();
                        course.setSku(UUID.randomUUID().toString());
                        course.setVendor(getVendor(token));
                        course.setName(Course_Name);


                        CourseDb courseDb = new CourseDb();

                        //courseDb.setName(Course_Name);
                        courseDb.setCOURSE_ID(Integer.parseInt(Course_id));
                        courseDb.setCOURSE_CODE(Course_Code);
                        courseDb.setCOURSE_NAME(Course_Name);
                        courseDb.setCOURSE_INST_CODE(Course_Instant_Code);
                        courseDb.setCOURSE_INST_NAME(Course_Instant_Name);
                        courseDb.setC_START_DTE(sdFormat.parse(Start_Date));
                        courseDb.setC_END_DTE(sdFormat.parse(End_Date));
                        courseDb.setC_RESULT(grade);
                        courseDb.setC_TIME(Integer.parseInt(Time));
                        //保存数据进入数据库
                        courseDbService.insertCourse(courseDb);
                        css_courseService.insertCss_Course(courseDb);
                        css_course_instService.insertCss_Course_Inst(courseDb);
//                        css_course_attdService.insertCss_Course_Attd(courseDb);


                        logger.info("Saving product: {}", courseDb.getCOURSE_ID());
                        System.out.println();
                        logger.info("The Sevice information ：{}", courseDb.getCOURSE_NAME());
                        courseApi.saveCourse(course);

                        event = new UploadEvent();
                        event.setState(course);
                        event.setEventType("progress");
                        brokerMessagingTemplate.convertAndSend("/topics/event",
                                JSON.toJSONString(event, SerializerFeature.BrowserCompatible));

                        Thread.sleep(200);
                    }

                    event = new UploadEvent();
                    event.setState("Uploaded filed deleted on server");
                    fh.delete();
                    event.setEventType("end");
                    brokerMessagingTemplate.convertAndSend("/topics/event",
                            JSON.toJSONString(event, SerializerFeature.BrowserCompatible));

                } catch (Exception ex) {
                    logger.error("Failed on saving information", ex);
                }
            });

            result.put("success", true);
            result.put("id", label);
            result.put("error", "");

            return result;
        } catch (IOException ex) {
            ex.printStackTrace();
            logger.error("Failed to process the uploaded image", ex);
            result.put("success", false);
            result.put("id", "");
            result.put("error", ex.getMessage());
            return result;
        }

    }
}
