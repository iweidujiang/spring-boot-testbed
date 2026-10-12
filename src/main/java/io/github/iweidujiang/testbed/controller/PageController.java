package io.github.iweidujiang.testbed.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 页面控制器
 * <p>
 * 返回 Thymeleaf 视图名称，前端通过 fetch 调用 REST API 获取数据。
 *
 * @author 微信公众号:苏渡苇 GitHub: https://github.com/iweidujiang
 * @since 2026-10-12
 */
@Controller
public class PageController {

    @GetMapping("/")
    public String index() {
        return "redirect:/page/experiments";
    }

    @GetMapping("/page/experiments")
    public String experiments(Model model) {
        model.addAttribute("activeMenu", "experiments");
        return "experiments";
    }
}
