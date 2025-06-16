package com.rw.config;

import com.alibaba.fastjson.JSON;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义请求成功后的反参
 */
public class AuthenticationSuccessHandlerConfig implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("msg", "认证成功");
        map.put("data", authentication);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(JSON.toJSONString(map));
    }
}
