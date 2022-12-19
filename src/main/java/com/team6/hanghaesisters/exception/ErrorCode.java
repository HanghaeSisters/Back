package com.team6.hanghaesisters.exception;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

	/* 400 BAD_REQUEST */
	USER_NOT_FOUND("회원을 찾을 수 없습니다.", BAD_REQUEST.value()),
	OVERLAP_USERID("중복된 아이디 입니다.", BAD_REQUEST.value()),
	MISMATCH_PASSWORD("비밀번호가 일치하지 않습니다.", BAD_REQUEST.value()),
	NOT_FOUND_POST("게시글을 찾을 수 없습니다", BAD_REQUEST.value()),
	NOT_FOUND_COMMENT("댓글을 찾을 수 없습니다", BAD_REQUEST.value()),
	UNAVAILABLE_MODIFICATION("작성자만 삭제/수정할 수 있습니다.", BAD_REQUEST.value()),
	INVALID_TOKEN("토큰이 유효하지 않습니다.", BAD_REQUEST.value()),
	EXPIRED_TOKEN("만료된 토큰입니다.", BAD_REQUEST.value()),
	UNSUPPORTED_TOKEN("지원되지 않는 토큰입니다.", BAD_REQUEST.value());

	private final String msg;
	private final int statusCode;

	ErrorCode(String msg, int statusCode) {
		this.msg = msg;
		this.statusCode = statusCode;
	}
}
