package com.example.lishui.config;

import lombok.SneakyThrows;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;
import java.nio.file.Paths;

/**
 * Created by jesse on 2020/11/19 下午8:39
 */
@Configuration
public class UploadConfig implements WebMvcConfigurer {
    @Override
    @SneakyThrows
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String dirPath= new ApplicationHome(this.getClass()).getDir().getAbsolutePath();
        dirPath = Paths.get(dirPath).resolve("upload").toString()+File.separator;
        //第三种
//        String path1 = ClassUtils.getDefaultClassLoader().getResource("").getPath();
//        System.out.println(URLDecoder.decode(path1, "utf-8"));
        //第四种
//        String path2 = ResourceUtils.getURL("classpath:").getPath();
//        System.out.println(path2);

        registry.addResourceHandler("/upload/**").addResourceLocations("file:"+dirPath);

    }
}
