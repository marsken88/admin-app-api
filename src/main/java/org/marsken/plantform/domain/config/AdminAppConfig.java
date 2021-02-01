package org.marsken.plantform.domain.config;

import org.marsken.plantform.domain.interceptor.AdminInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/1/28 1:37 下午
 * @description：
 * @modified By：
 * @version: $
 */
@Configuration
public class AdminAppConfig implements WebMvcConfigurer {

    @Autowired
    private AdminInterceptor adminInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(adminInterceptor);
    }
}
