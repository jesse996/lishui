package com.example.lishui.config;

import com.example.lishui.common.api.CommonResult;
import com.example.lishui.component.*;
import com.example.lishui.dao.entity.User;
import com.example.lishui.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.io.PrintWriter;
import java.time.Duration;
import java.util.Collections;
import java.util.Optional;

/**
 * Created by jesse on 2020/11/16 下午8:03
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserService userService;
    @Autowired
    private RestfulAccessDeniedHandler restfulAccessDeniedHandler;
    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;
    @Autowired
    VerifyCodeFilter verifyCodeFilter;


    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf()
                .disable()
                .sessionManagement()// 基于token，所以不需要session
                .maximumSessions(1)
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .and()
                .formLogin()
                .loginProcessingUrl("/login")
                .successHandler((req, res, authentication) -> {
                    UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//                    Object principal = authentication.getPrincipal();
//                    principal.clearPassword();
                    res.setContentType("application/json;charset=utf-8");
                    PrintWriter writer = res.getWriter();
                    writer.write(new ObjectMapper().writeValueAsString(CommonResult.success(principal)));
                    writer.flush();
                    writer.close();
                })
                .failureHandler((req, res, e) -> {
                    res.setContentType("application/json;charset=utf-8");
                    PrintWriter writer = res.getWriter();
                    writer.write(new ObjectMapper().writeValueAsString(CommonResult.failed(e.getMessage())));
                    writer.flush();
                    writer.close();
                })
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler((req, res, authentication) -> {
                    res.setContentType("application/json;charset=utf-8");
                    PrintWriter writer = res.getWriter();
                    writer.write(new ObjectMapper().writeValueAsString(CommonResult.success("注销成功")));
                    writer.flush();
                    writer.close();
                })
                .permitAll()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, // 允许对于网站静态资源的无授权访问
                        "/",
                        "/explorer/**",
                        "/druid",
                        "/*.html",
                        "/favicon.ico",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js",
                        "/swagger-resources/**",
                        "/webjars/springfox-swagger-ui/**"
                )
                .permitAll()
                .antMatchers(HttpMethod.OPTIONS)//跨域请求会先进行一次options请求
                .permitAll()
//                .antMatchers("/admin/login", "/admin/register")// 对登录注册要允许匿名访问
//                .permitAll()

                .anyRequest()// 除上面外的所有请求全部需要鉴权认证
//                .authenticated();
                .permitAll()
                .and()
                .cors()
                .configurationSource(corsConfigurationSource());
        ;
        // 禁用缓存
        httpSecurity.headers().cacheControl();
        // 添加JWT filter
//        httpSecurity.addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        //添加自定义未授权和未登录结果返回
        httpSecurity.exceptionHandling()
                .accessDeniedHandler(restfulAccessDeniedHandler)
                .authenticationEntryPoint(restAuthenticationEntryPoint);

        httpSecurity.addFilterBefore(verifyCodeFilter, UsernamePasswordAuthenticationFilter.class);
    }



    //    cors设置
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOriginPatterns(Collections.singletonList("*"));
//        corsConfiguration.setAllowedOrigins(Collections.singletonList("*"));//不能用这个
        corsConfiguration.setAllowedMethods(Collections.singletonList("*"));
        corsConfiguration.setAllowedHeaders(Collections.singletonList("*"));
        corsConfiguration.setMaxAge(Duration.ofHours(10));
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        //获取登录用户信息
        return username -> {
            Optional<User> user = userService.findUserByUsername(username);
            if (user.isPresent()) {
                return new UserDetailImpl(user.get());
            }
            throw new UsernameNotFoundException("用户名或密码错误");
        };
    }


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    //会话管理要提供这个类
    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }
}
