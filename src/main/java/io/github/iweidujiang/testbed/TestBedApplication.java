package io.github.iweidujiang.testbed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 万能测试项目启动类
 * <p>
 * 集成 Spring Boot 4.0.8 + Spring AI 2.0.1 + Prompt AB，
 * 供各类组件/框架集成测试使用。
 *
 * @author 微信公众号:苏渡苇 GitHub: https://github.com/iweidujiang
 * @since 2026-10-09
 */
@SpringBootApplication
public class TestBedApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestBedApplication.class, args);
    }
}
