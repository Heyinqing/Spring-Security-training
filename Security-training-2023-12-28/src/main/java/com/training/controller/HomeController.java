package com.training.controller;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/home")
    public String home() {
        SecurityContext context = SecurityContextHolder.getContext();
        return context.getAuthentication().getName() + "登录成功";
    }
}
