package io.github.iweidujiang.testbed.config;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.model.Generation;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Mock ChatModel 配置
 * <p>
 * 提供一个模拟的 ChatModel 实现，无需真实 API 密钥即可测试 Prompt AB 路由链路。
 * 返回固定格式的响应，便于验证路由和评估逻辑。
 * <p>
 * 如需使用真实 ChatModel，注释掉此配置并配置 spring.ai.openai.* 属性。
 *
 * @author 微信公众号:苏渡苇 GitHub: https://github.com/iweidujiang
 * @since 2026-10-09
 */
@Configuration
public class MockChatModelConfig {

    @Bean
    @Primary
    public ChatModel mockChatModel() {
        return new MockChatModel();
    }

    /**
     * 模拟 ChatModel，返回固定响应
     */
    static class MockChatModel implements ChatModel {

        @Override
        public ChatResponse call(Prompt prompt) {
            String userMessage = prompt.getContents();
            String reply = String.format("[MockAI] 收到消息: %s", userMessage);

            AssistantMessage assistantMessage = new AssistantMessage(reply);
            Generation generation = new Generation(assistantMessage);
            return new ChatResponse(java.util.List.of(generation));
        }
    }
}
