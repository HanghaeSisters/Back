package com.team6.hanghaesisters.controller;

import com.team6.hanghaesisters.dto.MsgResponseDto;
import com.team6.hanghaesisters.dto.UserDto;
import com.team6.hanghaesisters.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class UserController {

	private final UserService userService; //의존성주입

	@PostMapping("/signup")
	public MsgResponseDto signup(@RequestBody @Valid UserDto.SignupReqDto reqDto) {
		return userService.signup(reqDto);
	}

	@PostMapping("/login")
	public MsgResponseDto login(@RequestBody UserDto.LoginReqDto reqDto, HttpServletResponse httpServletResponse) {
		return userService.login(reqDto, httpServletResponse);
	}

	@GetMapping("/idcheck")
	public MsgResponseDto checkIdDuplication(@RequestParam("username") String username) {
		return userService.checkIdDuplication(username);
	}
}

