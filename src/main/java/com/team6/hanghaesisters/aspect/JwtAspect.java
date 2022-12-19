/*
package com.team6.hanghaesisters.aspect;

import com.team6.hanghaesisters.dto.PostRequestDto;
import com.team6.hanghaesisters.dto.PostResponseDto;
import com.team6.hanghaesisters.entity.Post;
import com.team6.hanghaesisters.entity.User;
import com.team6.hanghaesisters.jwt.JwtUtil;
import com.team6.hanghaesisters.repository.PostRepository;
import com.team6.hanghaesisters.repository.UserRepository;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@RequiredArgsConstructor
public class JwtAspect {

    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Around("execution(* com.team6.hangdaesisters.service..*.PostService.*(..))")
    public PostResponseDto jwtAspect(PostRequestDto postRequestDto, HttpServletRequest request) throws Throwable{
        String token = jwtUtil.resolveToken(request);
        Claims claims;

        // 토큰이 있는 경우에만 관심상품 추가 가능
        if (token != null) {
            if (jwtUtil.validateToken(token)) {
                // 토큰에서 사용자 정보 가져오기
                claims = jwtUtil.getUserInfoFromToken(token);
            } else {
                throw new IllegalArgumentException("Token Error");
            }

            // 토큰에서 가져온 사용자 정보를 사용하여 DB 조회
            User user = userRepository.findByUsername(claims.getSubject()).orElseThrow(
                    () -> new IllegalArgumentException("사용자가 존재하지 않습니다.")
            );

            // 요청받은 DTO 로 DB에 저장할 객체 만들기
            Post post = postRepository.saveAndFlush(new Post(postRequestDto, user.getId(), user.getUsername()));

            return new PostResponseDto(post);
        } else {
            return null;
        }
    }
}
*/
