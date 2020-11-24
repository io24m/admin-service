package com.github.io24m.adminservice.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.io24m.adminservice.common.annotation.SkipToken;
import com.github.io24m.adminservice.common.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

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
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        if (method.isAnnotationPresent(SkipToken.class)) {
            return true;
//            SkipToken skipToken = method.getAnnotation(SkipToken.class);
        }
        String token = request.getHeader("Admin-Token");
        try {
            String userId = JWT.decode(token).getAudience().get(0);
        } catch (Exception e) {
            response.setStatus(401);
            return false;
        }

        //根据userId查询数据库
        User user = new User();
        user.setUserId("0");
        user.setAccount("0");
        user.setPassword("1");
        user.setUserName("test");
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
        try {
            jwtVerifier.verify(token);
        } catch (Exception e) {
            response.setStatus(401);
            return false;
        }
        return true;
    }

}