package com.zgh.ai.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@RestController
@RequestMapping("/ai")
public class ChatController {
    private final ChatClient chatClient;

    @RequestMapping(value = "/chatStream", produces = "text/html;charset=utf-8")
    public Flux<String> chatStream(String prompt) {
        return chatClient.prompt()
                .user(prompt) // 用户提示词
                .stream() // 流式调用
                .content(); // 获取响应结果
    }
}


