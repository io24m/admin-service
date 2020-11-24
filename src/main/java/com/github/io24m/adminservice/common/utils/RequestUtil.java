package com.github.io24m.adminservice.common.utils;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lk1
 * @description
 * @create 2020-11-24 14:34
 */
public class RequestUtil {
    public static ServletRequestAttributes getRequestAttributes()
    {
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        return (ServletRequestAttributes) attributes;
    }
    public static HttpServletRequest getRequest()
    {
        return getRequestAttributes().getRequest();
    }

}
