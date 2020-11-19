package com.github.io24m.adminservice.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.io24m.adminservice.common.dto.AjaxResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lk1
 * @description
 * @create 2020-11-18 10:06
 */
@Configuration
public class PostHandlerInterceptor implements HandlerInterceptor {
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Max-Age", "36000");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Content-Type", "application/json;charset=utf-8");
        String header = request.getHeader("Admin-Token");
        System.out.println(request.getSession().getId());
//        || request.getSession().getAttribute(header) == null
        if (StringUtils.isBlank(header) ) {
            AjaxResponse err = AjaxResponse.error("无权限");
            err.setCode(0);
            String res = objectMapper.writeValueAsString(err);
            response.getWriter().write(res);
            return false;
        }
        return true;
    }

}