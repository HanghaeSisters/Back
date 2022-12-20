package com.team6.hanghaesisters.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class SignupRequestDto {

    @NotBlank(message = "username을 입력해주세요.")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z]).{4,10}$", message = "아이디는 알파벳 소문자와 숫자로 구성된 4~10자리여야 합니다.")
    private String username;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&].{8,15}$", message = "비밀번호는 알파벳 대소문자와 숫자, 특수문자로 구성된 8~15자리여야 합니다.")
    private String password;

//    private boolean admin = false;
//    private String adminToken = "";
}
