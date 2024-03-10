package com.ymx_project.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ymx_project.config.AuthenticationConfig;


import com.ymx_project.util.HeaderMapRequestWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@Slf4j
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
//        身份验证
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
                //主题 – 在这里，我将登录用户的用户名设置为主题
                .withSubject(((User) auth.getPrincipal()).getUsername())
                //到期时间 – 我们可以使用此标志设置 JWT 令牌的有效性。在这里，我们应该设置生成的令牌过期的日期。
                .withExpiresAt(new Date(System.currentTimeMillis()+ AuthenticationConfig.EXPIRATION_TIME))
                //签名 – 我们可以使用此方法设置带有密钥的签名算法。
                .sign(Algorithm.HMAC512(AuthenticationConfig.SECRET.getBytes()));
        log.info("token{}",token);
//        response.setHeader("Access-Control-Expose-Headers",JwtUtils.TOKEN_HEADER);
//        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(source));
        HeaderMapRequestWrapper requestWrapper = new HeaderMapRequestWrapper(request);


        try {
            response.setHeader(AuthenticationConfig.HEADER_STRING,AuthenticationConfig.TOKEN_PREFIX+token);
            response.setContentType("application/json;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_OK);
            PrintWriter out = response.getWriter();
            Map resultMap = new HashMap();
            resultMap.put("code", HttpServletResponse.SC_OK);
            resultMap.put("msg", "认证通过！");
            out.write(new ObjectMapper().writeValueAsString(resultMap));
            out.flush();
            out.close();
        }catch (Exception outEx){
            outEx.printStackTrace();
        }
    }

}
