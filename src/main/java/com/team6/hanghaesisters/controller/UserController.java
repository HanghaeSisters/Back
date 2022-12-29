package com.team6.hanghaesisters.controller;

import com.team6.hanghaesisters.dto.MsgResponseDto;
import com.team6.hanghaesisters.dto.UserDto;
import com.team6.hanghaesisters.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

	private final UserService userService;

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

