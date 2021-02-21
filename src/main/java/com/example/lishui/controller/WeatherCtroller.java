package com.example.lishui.controller;

import com.example.lishui.common.api.CommonResult;
import com.example.lishui.util.TemperatureUtils;
import com.example.lishui.vo.WeatherVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author cqc
 * @date 2021-02-21 16:51
 */
@RequestMapping("/api/weather")
@RestController
@Api(tags = "温度接口")
public class WeatherCtroller {
    @ApiOperation(value = "会议大屏温度")
    @GetMapping(value = "/getDayTemperature")
    public CommonResult<List<WeatherVO>> dayCount() {
        return CommonResult.success(TemperatureUtils.getWeatherDaily());
    }
}
