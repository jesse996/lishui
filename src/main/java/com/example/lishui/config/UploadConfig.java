package com.example.lishui.config;

import lombok.SneakyThrows;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletPath;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.File;
import java.net.URLDecoder;
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
        System.out.println("dirPath");
        System.out.println(dirPath);

        //第三种
//        String path1 = ClassUtils.getDefaultClassLoader().getResource("").getPath();
//        System.out.println(URLDecoder.decode(path1, "utf-8"));
        //第四种
//        String path2 = ResourceUtils.getURL("classpath:").getPath();
//        System.out.println(path2);

        registry.addResourceHandler("/upload/**").addResourceLocations("file:"+dirPath);

    }
}
