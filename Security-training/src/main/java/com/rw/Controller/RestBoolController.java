package com.rw.Controller;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/RestBoolController")
public class RestBoolController {

    @GetMapping("/getBool")
    public boolean getBool() {
        Date date = new Date();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getPrincipal());
        System.out.println(authentication.getCredentials());
        System.out.println(authentication.getDetails());
        System.out.println(authentication.getName());
        System.out.println(authentication.getAuthorities());
        new Thread() {
            @Override
            public void run() {
                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                System.out.println(authentication.getPrincipal());
            }
        }.start();
        return true;
    }
}
