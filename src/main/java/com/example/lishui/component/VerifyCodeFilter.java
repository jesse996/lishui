package com.example.lishui.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jesse on 2020/12/14 下午4:21
 */
@Component
public class VerifyCodeFilter extends OncePerRequestFilter {
    private String defaultFilterProcessUrl = "/login";
    @Autowired
    @Qualifier("handlerExceptionResolver")
    private HandlerExceptionResolver resolver;


    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        try {
            if ("POST".equalsIgnoreCase(request.getMethod()) && defaultFilterProcessUrl.equals(request.getServletPath())) {
                // 验证码验证
                String requestCaptcha = request.getParameter("code");
                String genCaptcha = (String) request.getSession().getAttribute("index_code");

                if (!StringUtils.hasText(genCaptcha))
                    throw new AuthenticationServiceException("请先获取验证码！");
                if (!StringUtils.hasText(requestCaptcha))
                    throw new AuthenticationServiceException("验证码不能为空!");
                if (!genCaptcha.equalsIgnoreCase(requestCaptcha)) {
                    throw new AuthenticationServiceException("验证码错误!");
                }
            }
            request.getSession().removeAttribute("index_code");
            filterChain.doFilter(request, response);
        } catch (AuthenticationServiceException e) {
//            e.printStackTrace();
            resolver.resolveException(request, response, null, e);
        }
    }
}
