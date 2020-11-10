package com.southwind.springboot_test.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName：CorsConfig
 * @Description： 跨域配置
 * @Author：HuangZhen
 * @Date 2020/9/13 19:11
 * @Versopn：1.0
 */

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")
                .allowedOrigins("*")
                // 不管是"GET","HEAD","POST","PUT","DELETE","POTIONS" 其中那个请求都可以
                .allowedMethods("GET","HEAD","POST","PUT","DELETE","POTIONS")
                .allowCredentials(true)
                .maxAge(3600)
                .allowedHeaders("*")
        ;

    }

}
