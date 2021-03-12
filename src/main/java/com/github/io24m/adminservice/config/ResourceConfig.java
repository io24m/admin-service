//package com.github.io24m.adminservice.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationManager;
//import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationProcessingFilter;
//
///**
// * @author lk1
// * @description
// * @create 2021-03-08 16:08
// */
//@Configuration
//public class ResourceConfig extends ResourceServerConfigurerAdapter {
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        //OAuth2AuthenticationManager
//        //OAuth2AuthenticationProcessingFilter
//        //http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
//        //请求权限配置
//        http.authorizeRequests()
//                //下边的路径放行,不需要经过认证
////                .antMatchers("/oauth/**", "/login", "/error/**").permitAll()
//                //OPTIONS请求不需要鉴权
//                //用户的增删改接口只允许管理员访问
//                .antMatchers("/").hasAnyAuthority("admin-service-all")
////                .antMatchers(HttpMethod.PUT, "/auth/user").hasAnyAuthority(Oauth2Constants.ROLE_ADMIN)
////                .antMatchers(HttpMethod.DELETE, "/auth/user").hasAnyAuthority(Oauth2Constants.ROLE_ADMIN)
////                //获取角色 权限列表接口只允许系统管理员及高级用户访问
////                .antMatchers(HttpMethod.GET, "/auth/role").hasAnyAuthority(Oauth2Constants.ROLE_ADMIN)
//                //其余接口没有角色限制，但需要经过认证，只要携带token就可以放行
//                .anyRequest()
//                .authenticated();
//    }
//
//    @Override
//    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
//        resources.resourceId("admin-service-resource");
//    }
//}
