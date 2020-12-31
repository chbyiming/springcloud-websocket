package com.beyond.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
// 此注解表示使用STOMP协议来传输基于消息代理的消息，此时可以在@Controller类中使用@MessageMapping
@EnableWebSocketMessageBroker
public class WebSocketAutoConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //本实例前端 sockjs 请求路径为 http://localhost:8888/client/websocket/web/socket
        registry.addEndpoint("/websocket/web/socket")         //websocket监听地址，sockjs连接地址（如果有配置项目路径【server.servlet.context-path】，需要加上）
                .setAllowedOrigins("*")         //允许跨域访问
                .withSockJS();                  //使用sockJS
    }
}