package org.marsken.plantform.domain.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author ：MarsKen
 * @date ：Created in 2021/1/29 4:46 下午
 * @description：
 * @modified By：
 * @version: $
 */
@Configuration
public class AdminWebSocketConfig {

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

}
