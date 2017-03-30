package com.liangjiange.cloud;

import com.liangjiange.cloud.util.MyMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author liangjiange
 * @since 2017-02-07 20:18
 */
@Controller
@SpringBootApplication
@MapperScan(basePackages = "com.liangjiange.cloud.mapper", markerInterface = MyMapper.class)
public class Application extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
