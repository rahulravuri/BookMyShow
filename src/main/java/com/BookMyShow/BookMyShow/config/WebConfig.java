package com.BookMyShow.BookMyShow.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.BookMyShow.BookMyShow.Utill.KeyUtil;

import java.security.PublicKey;
import com.BookMyShow.BookMyShow.config.headerValidationInterceptor;
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    headerValidationInterceptor headerValidationInterceptor;

    @Bean
    public PublicKey publicKey() throws Exception {
        return  KeyUtil.getPublicKey("publicKey.pem");
    }


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Apply CORS configuration to all endpoints
                .allowedOrigins("http://localhost") // Allow requests from your frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allow these HTTP methods
                .allowedHeaders("*") // Allow all headers
                .allowCredentials(true); // Allow credentials if needed
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(headerValidationInterceptor)
                .addPathPatterns("/Admin1/**")
                .addPathPatterns("/Bookingn/**");  // Apply to /admin/ routes
    }

}
