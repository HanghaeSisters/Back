package com.team6.hanghaesisters.controller;

import com.team6.hanghaesisters.dto.LoginRequestDto;
import com.team6.hanghaesisters.dto.MsgResponseDto;
import com.team6.hanghaesisters.dto.SignupRequestDto;
import com.team6.hanghaesisters.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController //Json형태로 객체 데이터를 반환하는데 사용됨
@RequestMapping("/api/user")
@RequiredArgsConstructor //생성자를 만들어야 하는 번거로움을 없애줌
public class UserController {

    private final UserService userService; //의존성주입

    @PostMapping("/signup")
    public MsgResponseDto signup(@RequestBody/*http요청을 자바객체로*/ @Valid SignupRequestDto signupRequestDto) {
        return userService.signup(signupRequestDto); //userservice의 signup 메소드 실행(매게값 signupRequestDto)
    }

    @PostMapping("/login")
    public MsgResponseDto login(@RequestBody LoginRequestDto loginRequestDto, HttpServletResponse response) {
        return userService.login(loginRequestDto, response);
    }

}

