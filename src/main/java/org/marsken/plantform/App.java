package org.marsken.plantform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author ：MarsKen
 * @date ：Created in 2020/9/14 9:42 下午
 * @description：应用启动类
 * @modified By：
 * @version: 1.0.0$
 */
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        System.out.println(new BCryptPasswordEncoder().encode("admin"));
    }
}
