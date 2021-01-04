package com.example.lishui.controller;

import com.example.lishui.common.api.CommonResult;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by jesse on 2020/11/19 下午7:06
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class UploadController {
//    private static final String filePath = "classpath:/static/";
//    private static final String UPLOAD_PATH_PREFIX = "static/";

    @PostMapping("/upload")
    @SneakyThrows
    public CommonResult<String> upload(@RequestParam("file") MultipartFile file) {

        //获取文件名
        String fileName = file.getOriginalFilename();
//        //获取文件后缀名
        String suffixName = ".jpg";
        try {
            suffixName = fileName.substring(fileName.lastIndexOf("."));
        } catch (Exception e) {
//            return CommonResult.failed("上传文件无后缀，请检查重新上传");
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmSS");
        Random random = new Random();
        //生成以 日期+随机数+后缀名的  新文件名  例 20200414_20000010.jpg
        String tempFileName = new StringBuilder().append(sdf.format(new Date())).append(random.nextInt(100)).append(suffixName).toString();

        String path = new ApplicationHome(getClass()).getDir().getPath();
        Path uploadPath = Paths.get(path + "/upload/");

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
        InputStream inputStream = file.getInputStream();

        Path filePath = uploadPath.resolve(tempFileName);
        Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);

        return CommonResult.success("/upload/" + tempFileName);

    }
}
