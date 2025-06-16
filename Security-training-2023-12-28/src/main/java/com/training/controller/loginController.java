package com.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/log")
public class loginController {

    @RequestMapping("in")
    public String in() {
        return "login";
    }
}
