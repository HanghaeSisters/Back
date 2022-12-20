package com.team6.hanghaesisters.security.exceptionhandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.team6.hanghaesisters.dto.ErrorResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

@RequiredArgsConstructor
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private final ObjectMapper om;

    private static final String DEFAULT_ERROR_MSG = "Full authentication is required to access this resource";
    private static final String CUSTOM_DEFAULT_ERROR_MSG = "로그인이 필요합니다";


    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        String errorMsg = authException.getMessage();

        if(errorMsg.equals(DEFAULT_ERROR_MSG)){
            errorMsg = CUSTOM_DEFAULT_ERROR_MSG;
        }

        ErrorResponseDto errorResponse = new ErrorResponseDto(errorMsg, HttpStatus.UNAUTHORIZED.value());

        String result = om.writeValueAsString(errorResponse);

        response.getWriter().write(result);

        response.setStatus(HttpStatus.UNAUTHORIZED.value());
    }
}

