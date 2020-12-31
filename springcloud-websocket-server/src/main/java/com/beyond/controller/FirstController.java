package com.beyond.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class FirstController {

    /**
     * 此方法用于点对点，一发一答
     *
     * @param message
     * @return
     */
    @SendTo("/websocket/read/response/message")//前端订阅消息的地址如果是这个，就会收到该方法的返回结果
    //MessageMapping 注解可写在类上，和 RequestMapping 类似
    @MessageMapping("/websocket1")//前端往这个地址推送数据，类似于 http 的方法请求
    public String readMessage(String message) {
        //todo something
        log.info("message {}", message);
        return JSONObject.parseObject(message).get("message") + " say: hello word.";
    }
}
