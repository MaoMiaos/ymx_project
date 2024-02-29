package com.ymx_project.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ymx_project.config.AuthenticationConfig;


import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter{

    private final AuthenticationManager authenticationManager;

    /**
     * 假设我们正在请求具有正确用户凭据的身份验证令牌
     * 然后传入请求将首先进入身份验证过滤器尝试身份验证方法
     * 之后我们需要从传入请求中捕获给定的凭据
     * 并为身份验证管理器提供处理验证。
     * @param request
     * @param response
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            com.ymx_project.entity.User creds = new ObjectMapper()
                    .readValue(request.getInputStream(),
                            com.ymx_project.entity.User.class);
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.getUsername(),
                            creds.getPassword(),
                            new ArrayList<>())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 实现一个成功的身份验证方法
     * 并且在该方法中
     * 我们应该生成一个新的 JWT令牌并将其返回给客户端。
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication auth) throws IOException, ServletException {
        String token = JWT.create()
                .withSubject(((User) auth.getPrincipal()).getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis()+ AuthenticationConfig.EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(AuthenticationConfig.SECRET.getBytes()));
        response.addHeader(AuthenticationConfig.HEADER_STRING,AuthenticationConfig.TOKEN_PREFIX+token);
    }

}
