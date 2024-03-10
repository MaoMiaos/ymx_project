package com.ymx_project.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import com.ymx_project.config.AuthenticationConfig;
import com.ymx_project.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 在这里，我们使用我们在 JWT 生成中使用的相同 SECRET 来验证传入的身份验证令牌
 * 然后验证它。然后，如果验证成功
 * 它将返回一个 UsernamePasswordAuthenticationToken，并且授权将成功完成。
 */
public class JWTAuthorizationFilter extends BasicAuthenticationFilter{

    UserService userService;

    public JWTAuthorizationFilter(AuthenticationManager authenticationManager,
                                  UserService userService) {
        super(authenticationManager);
        this.userService = userService;
    }

    /**
//     * 捕获传入的请求并检查是否存在任何令牌
//     * @param request
     * @param response
     * @param chain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String header = request.getHeader(AuthenticationConfig.HEADER_STRING);
        if(header == null || !header.startsWith(AuthenticationConfig.TOKEN_PREFIX)) {
            chain.doFilter(request,response);
            return;
        }

        UsernamePasswordAuthenticationToken authentication = getAuthentication(request);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);

    }




    /**
     * 验证请求中存在的令牌
     * @param request
     * @return
     */
    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(AuthenticationConfig.HEADER_STRING);
        if(token != null){
            //parse the token
            String user = JWT.require(Algorithm.HMAC512(AuthenticationConfig.SECRET.getBytes()))
                    .build()
                    .verify(token.replaceAll(AuthenticationConfig.TOKEN_PREFIX,""))
                    .getSubject();
            if(user != null) {
                return new UsernamePasswordAuthenticationToken(user,null,new ArrayList<>());
            }
            return null;
        }
        return null;
    }
}
