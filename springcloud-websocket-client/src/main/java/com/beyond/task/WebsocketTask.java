package com.beyond.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Async
@Slf4j
public class WebsocketTask {


/*
 *
 * 方式一 Autowired 属性注入 （不推荐使用）
//    @Autowired
//    private SimpMessagingTemplate simpMessagingTemplate;
 */

/*
 *
 * 方式二 set注入，在属性多的情况下推荐使用
//    private SimpMessagingTemplate simpMessagingTemplate;

//    @Autowired
//    public void setSimpMessagingTemplate(SimpMessagingTemplate simpMessagingTemplate) {
//        this.simpMessagingTemplate = simpMessagingTemplate;
//    }
 */

    /**
     * 方式三 构造函数注入，在属性少的情况下推荐使用
     */
    private final SimpMessagingTemplate simpMessagingTemplate;

    public WebsocketTask(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }


    /**
     * 此定时任务用于往 /websocket/send/response/message 订阅地址定时发送消息；发送消息需要依赖 SimpMessagingTemplate 消息模板
     */
    @Scheduled(cron = "*/5 * * * * ?")
    public void roundSendMessage() {
        //todo something
        //向 /websocket/send/response/message 订阅地址发送消息 [hello word!!]
        simpMessagingTemplate.convertAndSend("/websocket/send/response/message", "hello word!!");
    }
}
