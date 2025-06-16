package com.rw.Controller;

import com.alibaba.fastjson.JSON;
import com.rw.entity.LoginParams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class IndexController {

    //需使用@RequstMapping

    //自定义AuthenticationManager
    @Autowired
    private AuthenticationManager authenticationManager;

    @RequestMapping("login")
    public String index() {
        return "login";
    }

    @ResponseBody
    @RequestMapping("/toLogin")
    public String toLogin(LoginParams loginParams) {
        log.info("进入认证接口，参数为：{}", loginParams);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginParams.getUserName(), loginParams.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        return JSON.toJSONString(authenticate);
    }

    @RequestMapping("out")
    public String out() {
        return "logout";
    }

    @GetMapping("text")
    @ResponseBody
    public String text() {
        System.out.println("text");
        return "text";
    }
}
