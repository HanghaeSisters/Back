package com.team6.hanghaesisters.controller;

import com.team6.hanghaesisters.dto.MsgResponseDto;
import com.team6.hanghaesisters.dto.UserDto;
import com.team6.hanghaesisters.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController //Json형태로 객체 데이터를 반환하는데 사용됨
@RequestMapping("/api/user")
@RequiredArgsConstructor //생성자를 만들어야 하는 번거로움을 없애줌
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

