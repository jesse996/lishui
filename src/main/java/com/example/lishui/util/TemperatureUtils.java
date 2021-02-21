package com.example.lishui.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.example.lishui.vo.WeatherVO;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cqc
 * @date 2021-02-21 16:55
 */
public class TemperatureUtils {
    public static List<WeatherVO> getWeatherDaily() {
        List<WeatherVO> daily = null;
        RestTemplate restTemplate = new RestTemplate();
        JSONObject forObject = restTemplate.getForObject("https://api.seniverse.com/v3/weather/daily.json?key=Ss6j2UsGyr6KNI7ae&location=wenzhou&language=zh-Hans&unit=c&start=0&days=2", JSONObject.class);
        Object results = forObject.get("results");
        List<JSONObject> strings = JSON.parseObject(JSON.toJSONString(results), new TypeReference<ArrayList<JSONObject>>() {
        });
        JSONObject jsonObject = strings.get(0);
        daily = JSON.parseObject(JSON.toJSONString(jsonObject.get("daily")), new TypeReference<ArrayList<WeatherVO>>() {
        });
        return daily;
    }
}
