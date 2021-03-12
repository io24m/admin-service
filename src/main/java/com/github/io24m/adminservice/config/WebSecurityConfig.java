//package com.github.io24m.adminservice.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.authentication.logout.LogoutFilter;
//
//@Order(1)
//@Configuration
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.authorizeRequests()
//                //.antMatchers("/", "/index").authenticated()
//                //region 权限码
//                //.antMatchers("/sys/user/**").hasAuthority("sys-user")
//                .anyRequest().authenticated()//.hasAuthority("admin-service-a")
////                .requestMatchers(getRequestMatcher("/sys/notication/**")).hasAuthority("sys-notication")
////                .requestMatchers(getRequestMatcher("/sys/hospitalgp/**")).hasAuthority("sys-hospitalgp")
////                //endregion
//                //.antMatchers("/**/**").authenticated()
//                //.anyRequest().hasAuthority("not_allow")//这一行强制添加，必须加
//                //.and().logout().permitAll()
//                //关闭跨站请求防护
//                .and().csrf().disable();
//                //.headers().frameOptions().sameOrigin();
//
////        http.authorizeRequests()
////                .antMatchers("/", "/index").authenticated()
////                .antMatchers("/login", "/logout").permitAll()
////                .antMatchers("/**").authenticated()
//////                .anyRequest().hasAuthority("not_allow")
////                .and().logout().permitAll()
////                .and().csrf().disable();
//    }
//}
