package io.github.iweidujiang.testbed.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 聊天测试接口
 * <p>
 * 模拟业务聊天接口，用于验证 Prompt AB 路由是否生效。
 * 通过 sessionId 参数控制路由粘性。
 *
 * @author 微信公众号:苏渡苇 GitHub: https://github.com/iweidujiang
 * @since 2026-10-09
 */
@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatClient chatClient;

    public ChatController(ChatModel chatModel) {
        this.chatClient = ChatClient.builder(chatModel).build();
    }

    /**
     * 发送聊天消息
     *
     * @param message   用户消息
     * @param sessionId 会话标识（用于路由粘性）
     * @return AI 响应
     */
    @PostMapping
    public Map<String, Object> chat(@RequestParam String message,
                                    @RequestParam(defaultValue = "default-session") String sessionId) {
        String response = chatClient.prompt()
                .user(message)
                .advisors(a -> a.param("sessionId", sessionId))
                .call()
                .content();

        return Map.of(
                "message", message,
                "sessionId", sessionId,
                "response", response
        );
    }

    /**
     * 健康检查
     */
    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of("status", "UP", "service", "spring-boot-testbed");
    }
}
