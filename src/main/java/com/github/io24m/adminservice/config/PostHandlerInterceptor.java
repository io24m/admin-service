package com.github.io24m.adminservice.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.github.io24m.adminservice.common.annotation.SkipToken;
import com.github.io24m.adminservice.common.utils.AESUtil;
import com.github.io24m.adminservice.module.sys.user.SysUser;
import com.github.io24m.adminservice.module.sys.user.UserService;
import org.apache.commons.lang3.StringUtils;
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
    private UserService userService;

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
        if (StringUtils.isBlank(token)) {
            response.setStatus(401);
            return false;
        }
        token = AESUtil.Decrypt(token);
        String account;
        try {
            account = JWT.decode(token).getAudience().get(0);
        } catch (Exception e) {
            response.setStatus(401);
            return false;
        }
        SysUser user = userService.getUser(account);
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