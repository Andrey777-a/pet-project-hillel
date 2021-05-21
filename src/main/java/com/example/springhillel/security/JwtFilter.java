package com.example.springhillel.security;

import com.example.springhillel.api.service.crudservice.MyUserDetailsService;
import com.example.springhillel.model.datail.CustomUserDetails;
import io.jsonwebtoken.lang.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Component
//@Slf4j
//@NoLogging
public class JwtFilter extends GenericFilterBean{

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Override
//    @NoLogging
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

//        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
//        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        logger.info("do filter...");
        String token = getTokenFromRequest((HttpServletRequest) servletRequest);
        if (token != null && jwtProvider.validateToken(token)) {
            String userLogin = jwtProvider.getEmailFromToken(token);
            CustomUserDetails customUserDetails = myUserDetailsService.loadUserByUsername(userLogin);
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(customUserDetails, null, customUserDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(auth);
        }
        filterChain.doFilter(servletRequest, servletResponse);
//        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private String getTokenFromRequest(HttpServletRequest request) {
        String bearer = request.getHeader(AUTHORIZATION);
        if (Strings.hasText(bearer) && bearer.startsWith("Bearer ")) {
            return bearer.substring(7);
        }
        return null;
    }

}
