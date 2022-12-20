package com.team6.hanghaesisters.controller;

import com.team6.hanghaesisters.dto.MsgResponseDto;
import com.team6.hanghaesisters.dto.UserDto;
import com.team6.hanghaesisters.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;


@RestController //Json형태로 객체 데이터를 반환하는데 사용됨
@RequestMapping("/api/user")
@RequiredArgsConstructor //생성자를 만들어야 하는 번거로움을 없애줌
public class UserController {

    private final UserService userService; //의존성주입

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody @Valid UserDto.SignupReqDto reqDto) {
        userService.signup(reqDto);
        return ResponseEntity.ok(new MsgResponseDto("회원가입 되었습니다.", HttpStatus.OK.value()));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDto.LoginReqDto reqDto){

        // 생성된 토큰을 헤더에 담습니다.
        String accessToken = userService.login(reqDto);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.AUTHORIZATION, accessToken);

        // body, header, status
        return new ResponseEntity<>(new MsgResponseDto("로그인 되었습니다.", HttpStatus.OK.value()), httpHeaders, HttpStatus.OK);
    }

    @GetMapping("/idcheck")
    public ResponseEntity<?> checkIdDuplication(@RequestParam("username") String username) {
        System.out.println(username);

        if (userService.existsByUsername(username) == true) {
            return ResponseEntity.ok(new MsgResponseDto("이미 존재하는 아이디입니다.", HttpStatus.NOT_FOUND.value()));
        } else {
            return ResponseEntity.ok(new MsgResponseDto("사용 가능한 아이디입니다.", HttpStatus.OK.value()));
        }
    }

//    @GetMapping("/logout")
//    public String logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth != null) {
//            new SecurityContextLogoutHandler().logout(request, response, auth);
//        }
//        return "redirect:/";
//    }
}

