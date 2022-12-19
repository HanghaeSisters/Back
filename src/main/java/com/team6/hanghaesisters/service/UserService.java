package com.team6.hanghaesisters.service;

import com.team6.hanghaesisters.dto.*;
import com.team6.hanghaesisters.entity.UserRoleEnum;
import com.team6.hanghaesisters.entity.User;
import com.team6.hanghaesisters.jwt.JwtUtil;
import com.team6.hanghaesisters.repository.UserRepository;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    // ADMIN_TOKEN
     private static final String ADMIN_TOKEN = "AAABnvxRVklrnYxKZ0aHgTBcXukeZygoC";

    @Transactional
    public MsgResponseDto signup(SignupRequestDto signupRequestDto){
        //받아온 유저네임과 패스워드를 변수에 저장
        String username = signupRequestDto.getUsername();
        //받아온 password를 암호화하여 저장
        String password = passwordEncoder.encode(signupRequestDto.getPassword());

        //회원 중복 확인, 받아온 값이 유저레포지토리에 있는지 확인
        Optional<User> found = userRepository.findByUsername(username);
        if (found.isPresent()) { //존재하는 것을 찾았다면 에러처리
            throw new IllegalArgumentException("중복된 username 입니다.");
        }


        // 사용자 ROLE 확인
        UserRoleEnum role = UserRoleEnum.USER;
        if (signupRequestDto.isAdmin()) {
            if (!signupRequestDto.getAdminToken().equals(ADMIN_TOKEN)) {
                throw new IllegalArgumentException("관리자 암호가 틀려 등록이 불가능합니다.");
            }
            role = UserRoleEnum.ADMIN;
        }

        //user 객체에 두 값을 저장
        User user = new User(username, password, role);
        userRepository.save(user);

        return new MsgResponseDto("회원가입 성공", HttpStatus.OK.value());
    }

    @Transactional(readOnly = true)
    public MsgResponseDto login(LoginRequestDto loginRequestDto, HttpServletResponse response){
        String username = loginRequestDto.getUsername();
        String password = loginRequestDto.getPassword();

        //사용자 확인
        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new IllegalArgumentException("등록된 사용자가 없습니다.")
        );

        //비밀번호 확인
        if(!passwordEncoder.matches(password, user.getPassword())){
            throw  new IllegalArgumentException("회원을 찾을 수 없습니다.");
        }

        response.addHeader(JwtUtil.AUTHORIZATION_HEADER, jwtUtil.createToken(user.getUsername(), user.getRole()));

        return new MsgResponseDto("로그인 성공", HttpStatus.OK.value());
    }


}
