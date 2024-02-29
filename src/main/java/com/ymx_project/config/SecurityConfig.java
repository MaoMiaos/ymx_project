package com.ymx_project.config;


import com.ymx_project.filter.JWTAuthenticationFilter;
import com.ymx_project.filter.JWTAuthorizationFilter;
import com.ymx_project.service.AuthenticationUserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AuthenticationUserDetailService authenticationUserDetailService;
    /**
     * http.cors（）.and（）.csrf（）.disable（） – 这将从我们的 API 中禁用 CSRF 保护和跨域。
     * .antMatchers（HttpMethod.POST， AuthenticationConfigConstants.SIGN_UP_URL）.permitAll（） – 有了这个，我允许在没有身份验证的情况下访问我们的用户注册 API 端点。
     * .anyRequest（）.authenticated（） – 这将对进入我们 API 的每个请求进行身份验证。
     * .addFilter（new JWTAuthenticationFilter（authenticationManager（））） - 引入身份验证过滤器。
     * .addFilter（new JWTAuthorizationFilter（authenticationManager（）））– 引入授权过滤器。
     * .sessionManagement（）.sessionCreationPolicy（SessionCreationPolicy.STATELESS） - 将会话创建策略设置为 STATELESS。
     * auth.userDetailsService（authenticationUserDetailService）.passwordEncoder（bCryptPasswordEncoder）;– 在这里，我们使用密码编码器设置用户详细信息服务实现。
     * @param http
     */
    @Override
    public void configure( HttpSecurity http) throws Exception {
//        WebSecurity.IgnoredRequestConfigurer ignoring = web.ignoring();
//        ignoring.antMatchers(HttpMethod.GET);
//        ignoring.antMatchers(HttpMethod.POST);
    //开启cors跨区域名请求，关闭csrf验证，
        //users的post请求所有人都可以请求
        //其他的request都需要鉴权
        //jwt鉴权用户名密码
        //jwt鉴权token
        //把session改成无状态的session
        http.cors().and().csrf().disable().authorizeRequests()

                .antMatchers(HttpMethod.POST,AuthenticationConfig.SIGN_UP_URL)
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                .addFilter(new JWTAuthorizationFilter(authenticationManager()))
                //// this disables session creation on Spring Security
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);;

    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authenticationUserDetailService).passwordEncoder(bCryptPasswordEncoder);
    }

}

