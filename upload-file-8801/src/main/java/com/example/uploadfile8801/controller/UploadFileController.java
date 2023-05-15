package com.example.uploadfile8801.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

/**
 * @author: liaozhenyu
 * @date: 2022/04/14
 **/

@RestController
public class UploadFileController {

    @Value("${file.upload-dir}")
    private String fileUploadDir;

    private static class Parm {
        private String param1;
        private String paramB;

        public String getParam1() {
            return param1;
        }

        public void setParam1(String param1) {
            this.param1 = param1;
        }

        public String getParamB() {
            return paramB;
        }

        public void setParamB(String paramB) {
            this.paramB = paramB;
        }
    }

    @RequestMapping("upload")
    public String upload(MultipartFile[] onlineFile, MultipartFile[] otherFile, MultipartFile[] thirdPartFile, UploadFileController.Parm param, HttpServletRequest request) {

        System.out.println("begin.....");

        upload(onlineFile);
        upload(otherFile);
        upload(thirdPartFile);




        return "success";
    }

    private void upload(MultipartFile[] fileList) {
        for (MultipartFile file : fileList) {
            String fileName = file.getOriginalFilename();

            Path fileStorageLocation = Paths.get(fileUploadDir).toAbsolutePath().normalize();
            try {
                Files.createDirectories(fileStorageLocation);
                Path targetLocation = fileStorageLocation.resolve(fileName);
                Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            }  catch(Exception e) {
                e.printStackTrace();
                throw new RuntimeException("upload file fail");
            }
        }
    }
}


