package com.ymx_project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")//匹配所有路径
//                .allowedOrigins("*")// 允许的来源
//                .allowedMethods("GET", "POST", "PUT", "DELETE")// 允许的 HTTP 方法
//                .allowedHeaders("*") // 允许的请求头
//                .allowCredentials(true) // 是否允许携带凭证（如 Cookies）
//                .maxAge(3600); // 预检请求的缓存时间（秒）
//    }

//    //BCryptPasswordEncoder 作为自定义 bean
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
