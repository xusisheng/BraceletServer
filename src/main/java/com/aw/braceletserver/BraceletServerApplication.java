package com.aw.braceletserver;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableCaching
@EnableScheduling
public class BraceletServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BraceletServerApplication.class, args);

        System.out.println("Start....");
        JSONObject jsonObject = new JSONObject();
        JSONArray ja = new JSONArray();
        ja.add(10000);
        ja.add(10001);
        System.out.println(ja);
        System.out.println("End.");
    }

}
