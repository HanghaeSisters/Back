package com.team6.hanghaesisters.service;

import com.team6.hanghaesisters.dto.*;
import com.team6.hanghaesisters.security.jwt.JwtUtil;
import com.team6.hanghaesisters.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class UserService {
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;


    public void signup(UserDto.SignupReqDto dto) {
        userRepository.save(dto.toEntity());
    }

    public String login(UserDto.LoginReqDto dto){

        //인증 객체(인증 토큰)을 직접 만들어 인증을 진행합니다.
        //아직 인증 전 객체입니다.
        UsernamePasswordAuthenticationToken beforeAuthentication = new UsernamePasswordAuthenticationToken(dto.username(), dto.password());

        //authenticationManager에게 인증을 요청하고, authenticationProvider에게 인증을 위임하여
        // authenticationProvider에서 인증 진행 후 인증 완료된 인증 객체를 받습니다.
        Authentication afterAuthentication = authenticationManagerBuilder.getObject().authenticate(beforeAuthentication);

        //인증 완료된 객체로 JWT를 생성합니다.
        return jwtUtil.generateToken(afterAuthentication);
    }

    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }
}
