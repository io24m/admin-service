package com.github.io24m.adminservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.*;

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
        post.excludePathPatterns("/swagger-ui.html");
        post.excludePathPatterns("/v2/**");
        post.excludePathPatterns("/swagger-resources/**");
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
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 解决静态资源无法访问
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");
        // 解决swagger无法访问
        registry.addResourceHandler("/swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        // 解决swagger的js文件无法访问
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
