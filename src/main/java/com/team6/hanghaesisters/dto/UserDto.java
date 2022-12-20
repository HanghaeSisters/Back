package com.team6.hanghaesisters.dto;

import com.team6.hanghaesisters.entity.User;
import com.team6.hanghaesisters.validation.ValidSignup;
import jakarta.validation.constraints.NotBlank;

/**
 * inner class로 구성한 DTO 클래스
 * java 14 이후 추가된 record를 사용
 */
public class UserDto {

    @ValidSignup
    public record SignupReqDto(String username, String password){

        public User toEntity(){
            return new User(this.username, this.password);
        }

    }

    public record LoginReqDto(@NotBlank(message = "유저명을 입력해 주세요") String username,
                              @NotBlank(message = "비밀번호를 입력해 주세요") String password){

    }

}
