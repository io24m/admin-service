package com.github.io24m.adminservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * @author lk1
 * @description
 * @create 2020-11-18 9:43
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
    private final PostHandlerInterceptor postHandlerInterceptor;

    @Autowired
    public WebMvcConfig(PostHandlerInterceptor postHandlerInterceptor) {
        this.postHandlerInterceptor = postHandlerInterceptor;
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        AntPathMatcher matcher = new AntPathMatcher();
        matcher.setCaseSensitive(false);
        configurer.setPathMatcher(matcher);
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        InterceptorRegistration post = registry.addInterceptor(postHandlerInterceptor);
        post.addPathPatterns("/**");
    }

    @Bean
    public JsonArgumentResolver jsonArgumentResolver() {
        return new JsonArgumentResolver();
    }

    @Override
    protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        super.addArgumentResolvers(argumentResolvers);
        argumentResolvers.add(jsonArgumentResolver());
    }
}
