package com.example.lishui.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;

/**
 * Created by jesse on 2020/12/25 下午3:12
 */
@Configuration
public class SpringSessionConfig {
    @Bean
    public CookieSerializer httpSessionIdResolver() {
        DefaultCookieSerializer cookieSerializer = new DefaultCookieSerializer();
        // 取消仅限同一站点设置
        cookieSerializer.setCookieName("JSESSIONID");
        cookieSerializer.setUseHttpOnlyCookie(true);
        cookieSerializer.setUseSecureCookie(true);
        cookieSerializer.setSameSite(null);
        return cookieSerializer;
//        DynamicCookieMaxAgeCookieSerializer serializer = new DynamicCookieMaxAgeCookieSerializer();
//        serializer.setCookieName("JSESSIONID");
//        serializer.setDomainName("localhost");
//        serializer.setCookiePath("/");
//        serializer.setCookieMaxAge(3600);
//        serializer.setSameSite("Lax");  // 设置SameSite属性
//        serializer.setUseHttpOnlyCookie(true);
//        serializer.setUseSecureCookie(false);
//        return serializer;
    }
}
