package org.marsken.plantform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：MarsKen
 * @date ：Created in 2020/9/14 9:42 下午
 * @description：应用启动类
 * @modified By：
 * @version: 1.0.0$
 */
@SpringBootApplication
@MapperScan(basePackages={"org.marsken.plantform.infrastructure.mapper"})
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
