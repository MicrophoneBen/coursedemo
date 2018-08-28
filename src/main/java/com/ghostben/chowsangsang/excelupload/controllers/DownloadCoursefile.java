package com.ghostben.chowsangsang.excelupload.controllers;


import com.ghostben.chowsangsang.excelupload.services.DbService.CourseDbService;
import com.ghostben.chowsangsang.excelupload.viewmodels.CourseDb;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class DownloadCoursefile {
    @Autowired
    CourseDbService courseDbService;

    @GetMapping("/ExcelDownloads")
    public void downloadAllClassmate(HttpServletResponse response) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("信息表");

        List<CourseDb> courseDbList = courseDbService.getCourseInfo();

        //设置要导出的文件的名字
        String fileName = "Course_List"  + ".xls";
        //新增数据行，并且设置单元格数据

        int rowNum = 1;

        String[] headers = { "Course_id", "Course_Code", "Course_Name", "Course_Instant_Code","Course_Instant_Name","Start_Date","End_Date","Result","Time"};
        //headers表示excel表中第一行的表头

        HSSFRow row = sheet.createRow(0);
        //在excel表中添加表头

        for(int i=0;i<headers.length;i++){
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
        SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd");
        //在表中存放查询到的数据放入对应的列
        for(CourseDb courseDb : courseDbList){
            HSSFRow row1 = sheet.createRow(rowNum);
            row1.createCell(0).setCellValue(courseDb.getCOURSE_ID());
            row1.createCell(1).setCellValue(courseDb.getCOURSE_CODE());
            row1.createCell(2).setCellValue(courseDb.getCOURSE_NAME());
            row1.createCell(3).setCellValue(courseDb.getCOURSE_INST_CODE());
            row1.createCell(4).setCellValue(courseDb.getCOURSE_INST_NAME());
            row1.createCell(5).setCellValue(sdFormat.format(courseDb.getC_START_DTE()));
            row1.createCell(6).setCellValue(sdFormat.format(courseDb.getC_END_DTE()));
            row1.createCell(7).setCellValue(courseDb.getC_RESULT());
            row1.createCell(8).setCellValue(courseDb.getC_TIME());
            rowNum++;
        }

        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        response.flushBuffer();
        workbook.write(response.getOutputStream());
    }
}
