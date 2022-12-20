package com.team6.hanghaesisters.security.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.team6.hanghaesisters.dto.ErrorResponse;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.rememberme.InvalidCookieException;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final ObjectMapper om;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = jwtUtil.extractToken(request.getHeader(JwtUtil.AUTHORIZATION_HEADER));

        if (StringUtils.hasText(token)) {

            try {
                jwtUtil.validateToken(token);
                setAuthentication(token);
                filterChain.doFilter(request, response);
            } catch (InvalidCookieException e) {
                sendErrorMsg(e, response);
            }
        } else {

            filterChain.doFilter(request, response);
        }
    }

    private void setAuthentication(String token) {
        Authentication authentication = jwtUtil.getAuthentication(token);

        SecurityContext securityContext = SecurityContextHolder.getContext();

        securityContext.setAuthentication(authentication);
    }

    private void sendErrorMsg(Exception e, HttpServletResponse response) {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        ErrorResponse errorResponse = new ErrorResponse(e.getMessage());

        try {
            String result = om.writeValueAsString(errorResponse);
            response.getWriter().write(result);
        } catch (IOException ex) {
            log.error(ex.getMessage(), ex);
        }
    }

}

//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//
//        String token = jwtUtil.resolveToken(request);
//
//        if (token != null) {
//            if (!jwtUtil.validateToken(token)) {
//                jwtExceptionHandler(response, "Token Error", HttpStatus.UNAUTHORIZED.value());
//                return;
//            }
//            Claims info = jwtUtil.getUserInfoFromToken(token);
//            setAuthentication(info.getSubject());
//        }
//        filterChain.doFilter(request, response);
//    }
//
//    public void setAuthentication(String username) {
//        SecurityContext context = SecurityContextHolder.createEmptyContext();
//        Authentication authentication = jwtUtil.createAuthentication(username);
//        context.setAuthentication(authentication);
//
//        SecurityContextHolder.setContext(context);
//    }
//
//    public void jwtExceptionHandler(HttpServletResponse response, String msg, int statusCode) {
//        response.setStatus(statusCode);
//        response.setContentType("application/json");
//        try {
//            String json = new ObjectMapper().writeValueAsString(new MsgResponseDto(msg, statusCode));
//            response.getWriter().write(json);
//        } catch (Exception e) {
//            log.error(e.getMessage());
//        }
//    }
//
//}
