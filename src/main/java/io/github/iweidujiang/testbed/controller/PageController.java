package io.github.iweidujiang.testbed.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

/**
 * 页面控制器
 * <p>
 * TestBed 通用测试平台页面路由。
 * 首页为工具仪表盘，每个工具下有功能模块，每个模块下有可执行测试用例。
 *
 * @author 微信公众号:苏渡苇 GitHub: https://github.com/iweidujiang
 * @since 2026-10-12
 */
@Controller
public class PageController {

    @GetMapping("/")
    public String dashboard() {
        return "dashboard";
    }

    @GetMapping("/page/prompt-ab")
    public String promptAb(Model model) {
        model.addAttribute("breadcrumb", List.of(
                Map.of("label", "Spring AI Prompt AB", "url", "/page/prompt-ab")
        ));
        return "prompt-ab";
    }

    @GetMapping("/page/prompt-ab/experiments")
    public String experiments(Model model) {
        model.addAttribute("breadcrumb", List.of(
                Map.of("label", "Spring AI Prompt AB", "url", "/page/prompt-ab"),
                Map.of("label", "实验管理", "url", "/page/prompt-ab/experiments")
        ));
        return "experiments";
    }
}
