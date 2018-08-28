package com.ghostben.chowsangsang.excelupload.controllers;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ghostben.chowsangsang.excelupload.services.DbService.CourseInfoDbService;
import com.ghostben.chowsangsang.excelupload.services.DbService.Css_Course_AttdService;
import com.ghostben.chowsangsang.excelupload.services.apiservice.CourseInforApi;
import com.ghostben.chowsangsang.excelupload.utils.DataRow;
import com.ghostben.chowsangsang.excelupload.utils.DataTable;
import com.ghostben.chowsangsang.excelupload.utils.ExcelTable;
import com.ghostben.chowsangsang.excelupload.viewmodels.Course;
import com.ghostben.chowsangsang.excelupload.viewmodels.CourseInfoDb;
import com.ghostben.chowsangsang.excelupload.viewmodels.CourseInfor;
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


@Controller
public class UploadCoreInfoExcelController {

        ThreadFactory nThreadFactory = new ThreadFactoryBuilder().setNameFormat("Demo-pool-%d").build();
        ExecutorService threadpool = new ThreadPoolExecutor(5, 200, Long.MAX_VALUE ,TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), nThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        private ListeningExecutorService executor = MoreExecutors.listeningDecorator(threadpool);

        private static final Logger logger = LoggerFactory.getLogger(UploadCoreInfoExcelController.class);

        @Autowired
        CourseInforApi courseInforApi;
        @Autowired
        CourseInfoDbService courseInfoDbService;
        @Autowired
        Css_Course_AttdService css_course_attdService;
        @Autowired
        private SimpMessagingTemplate brokerMessagingTemplate;

        private String getVendor(String token) {
            return "vendor";
        }

        @RequestMapping(value = "/erp/upload-excel", method = RequestMethod.POST)
        public @ResponseBody
        Map<String, Object> uploadProductCsv(@RequestParam("file") MultipartFile file,
                                             //在csv 中做的处理，所以还是要处理这个模块
                                             @RequestParam("token") String token) throws ServletException, IOException {
            logger.info("upload-excel invoked.");

            Map<String, Object> result = new HashMap<>();
            //result部分，记录数据量的大小

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
                        inputStream.close();
                        //读入Excel文件之后关闭输入流
                        int rowCount = table.rowCount();
                        //从输入流中得到行数目，然后进行处理
                        for (int i = 0; i < rowCount; ++i) {
                            DataRow row = table.row(i);
                            String Employee_No = row.cell("Employee_No");
                            String Employee_Name = row.cell("Employee_Name");
                            String Section = row.cell("Section");
                            String Department = row.cell("Department");
                            String Title = row.cell("Title");
                            String Course_Code = row.cell("Course_Code");
                            String Course_Name = row.cell("Course_Name");
                            String Course_Instant_Code = row.cell("Course_Instant_Code");
                            String Course_Instant_Name = row.cell("Course_Instant_Name");
                            String Start_Date = row.cell("Start_Date");
                            String End_Date = row.cell("End_Date");
                            String Result = row.cell("Result");
                            String Time = row.cell("Time");


                            SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd");
                            CourseInfor courseInfor = new CourseInfor();
                            courseInfor.setSku(UUID.randomUUID().toString());
                            courseInfor.setVendor(getVendor(token));
                            //数据传输的显示
                            courseInfor.setName(Employee_Name);

                            CourseInfoDb courseInfoDb = new CourseInfoDb();
                            courseInfoDb.setCOURSE_CODE(Course_Code);
                            courseInfoDb.setCOURSE_NAME(Course_Name);
                            courseInfoDb.setCOURSE_INST_CODE(Course_Instant_Code);
                            courseInfoDb.setCOURSE_INST_NAME(Course_Instant_Name);
                            courseInfoDb.setC_START_DTE(sdFormat.parse(Start_Date));
                            courseInfoDb.setC_END_DTE(sdFormat.parse(End_Date));
                            courseInfoDb.setC_RESULT(Result);
                            courseInfoDb.setC_TIME(Integer.parseInt(Time));
                            courseInfoDb.setEMPL_NBR(Employee_No);
                            courseInfoDb.setEMPL_NAM(Employee_Name);
                            courseInfoDb.setEMPL_SEC(Section);
                            courseInfoDb.setEMPL_DEPT(Department);
                            courseInfoDb.setEMPL_TIT(Title);
                            courseInfoDbService.insertCourseInfoDb(courseInfoDb);
                            css_course_attdService.insertCss_Course_Attd(courseInfoDb);


                            logger.info("Saving Employee: {}", courseInfoDb.getEMPL_NAM());
                            courseInforApi.saveCourseInfor(courseInfor);
                            System.out.println();
                            logger.info("The Service information ：{}", courseInfoDb.getEMPL_NBR());


                            event = new UploadEvent();
                            event.setState(courseInfor);
                            event.setEventType("progress");
                            brokerMessagingTemplate.convertAndSend("/topics/event",
                                    JSON.toJSONString(event, SerializerFeature.BrowserCompatible));

                            Thread.sleep(100);
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
                logger.error("Failed to process the uploaded image", ex);
                result.put("success", false);
                result.put("id", "");
                result.put("error", ex.getMessage());
                return result;
            }

        }

 }
