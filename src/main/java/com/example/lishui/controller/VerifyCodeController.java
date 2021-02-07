package com.example.lishui.controller;

import com.example.lishui.common.utils.VerifyCode;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by jesse on 2020/12/14 下午4:16
 */
@RestController
@Api(tags = "验证码接口")
public class VerifyCodeController {
    @GetMapping("/api/vercode")
    @Operation(summary = "获取验证码",description = "获取验证码")
    public void code(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("image/jpeg");
        resp.setHeader("Cache-Control", "no-cache");
        resp.setHeader("Expire", "0");
        resp.setHeader("Pragma", "no-cache");

        VerifyCode vc = new VerifyCode();
        BufferedImage image = vc.getImage();
        String text = vc.getText();
        HttpSession session = req.getSession();
        session.setAttribute("index_code", text);
        VerifyCode.output(image, resp.getOutputStream());
    }
}
