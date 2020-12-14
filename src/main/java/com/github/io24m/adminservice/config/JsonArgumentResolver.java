package com.github.io24m.adminservice.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.io24m.adminservice.common.annotation.JsonParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * @author lk1
 * @description
 * @create 2020-12-14 13:27
 */
public class JsonArgumentResolver implements HandlerMethodArgumentResolver {
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.hasParameterAnnotation(JsonParam.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        HttpServletRequest request = ((ServletWebRequest) nativeWebRequest).getRequest();
        Object jsonParamObject = request.getAttribute("jsonParamObject");
        if (jsonParamObject == null) {
            BufferedReader reader = request.getReader();
            StringBuilder sb = new StringBuilder();
            String param = "" ;
            while ((param = reader.readLine()) != null) {
                sb.append(param);
            }
            jsonParamObject = objectMapper.readValue(sb.toString(), Map.class);
            request.setAttribute("jsonParamObject", jsonParamObject);
        }
        String paramName = methodParameter.getParameterName();
        JsonParam methodAnnotation = methodParameter.getParameterAnnotation(JsonParam.class);
        if (methodAnnotation != null && !StringUtils.isBlank(methodAnnotation.value())) {
            paramName = methodAnnotation.value();
        }
        Object o = ((Map) jsonParamObject).get(paramName);
        if (o == null) {
            return null;
        }
        return getParamValue(o.toString(), methodParameter.getParameterType());
    }

    private Object getParamValue(String value, Class clazz) {
        if (clazz.equals(String.class)) {
            return value;
        }
        if (clazz.equals(Integer.class) || clazz.equals(int.class)) {
            return Integer.valueOf(value);
        }
        if (clazz.equals(Long.class) || clazz.equals(long.class)) {
            return Long.valueOf(value);
        }
        if (clazz.equals(Float.class) || clazz.equals(float.class)) {
            return Float.valueOf(value);
        }
        if (clazz.equals(Double.class) || clazz.equals(double.class)) {
            return Double.valueOf(value);
        }
        if (clazz.equals(LocalDate.class)) {
            return LocalDate.parse(value);
        }
        if (clazz.equals(LocalDateTime.class)) {
            return LocalDateTime.parse(value);
        }
        if (clazz.equals(BigDecimal.class)) {
            return new BigDecimal(value);
        }
        return null;
    }
}
