-- 初始化测试数据：一个实验 + 两个变体
-- 注意：表结构由 prompt-ab-core 的 V1__init_experiment.sql 创建

-- 插入实验
INSERT INTO ab_experiment (experiment_key, description, status)
VALUES ('demo-exp', '演示实验：测试不同 Prompt 风格的效果', 'ACTIVE');

-- 插入变体 A：简洁风格（50% 流量）
INSERT INTO ab_variant (experiment_id, variant_key, prompt_template, traffic_pct, is_active)
SELECT id, 'variant-a', '请用简洁的语言回答以下问题', 50, TRUE
FROM ab_experiment
WHERE experiment_key = 'demo-exp';

-- 插入变体 B：详细风格（50% 流量）
INSERT INTO ab_variant (experiment_id, variant_key, prompt_template, traffic_pct, is_active)
SELECT id, 'variant-b', '请详细且全面地回答以下问题，包含示例和解释', 50, TRUE
FROM ab_experiment
WHERE experiment_key = 'demo-exp';
