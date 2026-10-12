# Spring Boot TestBed — 万能测试项目

集成常用组件的 Spring Boot 测试项目，供各类组件/框架集成测试使用。

## 技术栈

- Spring Boot 4.0.8
- Spring AI 2.0.1
- JDK 21
- H2 内存数据库（兼容 MySQL 模式）
- Flyway 数据库迁移
- Prompt AB（A/B 测试框架）

## 快速启动

```bash
# 先构建 prompt-ab 到本地仓库
cd spring-ai-prompt-ab
mvn clean install -DskipTests

# 启动测试项目
cd spring-boot-testbed
mvn spring-boot:run
```

## 内置功能

| 功能 | 端点 | 说明 |
|------|------|------|
| 聊天测试 | `POST /api/chat?message=xxx&sessionId=yyy` | 验证 Prompt AB 路由 |
| 健康检查 | `GET /api/chat/health` | 服务状态 |
| 实验管理 | `/api/experiments/**` | Prompt AB REST API |
| H2 控制台 | `GET /h2-console` | JDBC URL: `jdbc:h2:mem:testbed` |
| Actuator | `GET /actuator/health` | 监控端点 |

## 预置测试数据

- 实验：`demo-exp`（ACTIVE 状态）
- 变体 A：`variant-a`（简洁风格，50% 流量）
- 变体 B：`variant-b`（详细风格，50% 流量）

## Mock ChatModel

默认使用 Mock ChatModel，无需 API 密钥即可测试路由链路。
如需使用真实 OpenAI，修改 `MockChatModelConfig.java` 并配置 `spring.ai.openai.api-key`。

## 测试 Prompt AB 示例

```bash
# 发送聊天请求（不同 sessionId 路由到不同变体）
curl -X POST "http://localhost:8080/api/chat?message=你好&sessionId=user-1"
curl -X POST "http://localhost:8080/api/chat?message=你好&sessionId=user-2"

# 查询实验
curl http://localhost:8080/api/experiments/demo-exp

# 查询变体列表
curl http://localhost:8080/api/experiments/demo-exp/variants
```
