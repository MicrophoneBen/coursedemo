package com.ghostben.chowsangsang.excelupload;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Created by xschen on 8/11/2017.
 */
@MapperScan(value = "com.ghostben.chowsangsang.excelupload.entitymapper")
@SpringBootApplication
public class SpringBootExcelUploadApplication {
   public static void main(String[] args) {
      SpringApplication.run(SpringBootExcelUploadApplication.class, args);
   }
}
