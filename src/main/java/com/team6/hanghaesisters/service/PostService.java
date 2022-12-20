//package com.team6.hanghaesisters.service;

import com.team6.hanghaesisters.dto.MsgResponseDto;
import com.team6.hanghaesisters.dto.PostRequestDto;
import com.team6.hanghaesisters.dto.PostResponseDto;
import com.team6.hanghaesisters.dto.PostSampleResponseDto;
import com.team6.hanghaesisters.entity.Post;
import com.team6.hanghaesisters.entity.User;
import com.team6.hanghaesisters.exception.CustomException;
import com.team6.hanghaesisters.exception.ErrorCode;
import com.team6.hanghaesisters.repository.PostRepository;
import com.team6.hanghaesisters.repository.UserRepository;
<<<<<<< HEAD
import com.team6.hanghaesisters.security.jwt.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
=======
import com.team6.hanghaesisters.util.ExceptionFunctions;
>>>>>>> 6b5131438b1804d6691c09a45c57afd9a25bd20a
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
//@Service
//@RequiredArgsConstructor
//@Slf4j
//public class PostService {
//
//    private final PostRepository postRepository;
//    private final UserRepository userRepository;
//    private final JwtUtil jwtUtil;
//
//    @Transactional
//    public PostResponseDto create(PostRequestDto postRequestDto, HttpServletRequest request) {
//        log.info("PostService create() 실행 완");
//        String token = jwtUtil.resolveToken(request);
//        Claims claims;
//
//        // 토큰이 있는 경우에만 관심상품 추가 가능
//        if (token != null) {
//            if (jwtUtil.validateToken(token)) {
//                // 토큰에서 사용자 정보 가져오기
//                claims = jwtUtil.getUserInfoFromToken(token);
//            } else {
//                throw new CustomException(ErrorCode.INVALID_TOKEN);
//            }
//
//            // 토큰에서 가져온 사용자 정보를 사용하여 DB 조회
//            User user = userRepository.findByUsername(claims.getSubject()).orElseThrow(
//                    () -> new CustomException(ErrorCode.USER_NOT_FOUND)
//            );
//
//            // 요청받은 DTO 로 DB에 저장할 객체 만들기
//            Post post = postRepository.saveAndFlush(new Post(postRequestDto, user.getUsername()));
//
//            return new PostResponseDto(post);
//        } else {
//            return null;
//        }
//    }
//
//    @Transactional
//    public PostResponseDto readOne(Long id, HttpServletRequest request) {
//        // Request에서 Token 가져오기
//        String token = jwtUtil.resolveToken(request);
//        Claims claims;
//
//        // 토큰이 있는 경우에만 관심상품 조회 가능
//        if (token != null) {
//            // Token 검증
//            if (jwtUtil.validateToken(token)) {
//                claims = jwtUtil.getUserInfoFromToken(token);
//            } else {
//                throw new CustomException(ErrorCode.INVALID_TOKEN);
//            }
//
//            User user = userRepository.findByUsername(claims.getSubject()).orElseThrow(
//                    () -> new CustomException(ErrorCode.USER_NOT_FOUND)
//            );
//
//            Post post = postRepository.findById(id).orElseThrow(
//                    () -> new CustomException(ErrorCode.NOT_FOUND_POST)
//            );
//
//            return new PostResponseDto(post);
//
//        } else {
//            return null;
//        }
//    }
//
//    @Transactional
//    public PostResponseDto update(Long id, PostRequestDto postRequestDto,
//                                  HttpServletRequest request) {
//        // Request에서 Token 가져오기
//        String token = jwtUtil.resolveToken(request);
//        Claims claims;
//
//        // 토큰이 있는 경우에만 관심상품 조회 가능
//        if (token != null) {
//            // Token 검증
//            if (jwtUtil.validateToken(token)) {
//                claims = jwtUtil.getUserInfoFromToken(token);
//            } else {
//                throw new CustomException(ErrorCode.INVALID_TOKEN);
//            }
//
//            // 토큰에서 가져온 사용자 정보를 사용하여 DB 조회
//            User user = userRepository.findByUsername(claims.getSubject()).orElseThrow(
//                    () -> new CustomException(ErrorCode.USER_NOT_FOUND)
//            );
//
//            Post post = postRepository.findByIdAndUsername(id, user.getUsername()).orElseThrow(
//                    () -> new CustomException(ErrorCode.UNAVAILABLE_MODIFICATION)
//            );
//            post.update(postRequestDto);
//            return new PostResponseDto(post);
//        } else {
//            return null;
//        }
//    }
//
//    @Transactional
//    public MsgResponseDto delete(Long id, HttpServletRequest request) {
//        // Request에서 Token 가져오기
//        String token = jwtUtil.resolveToken(request);
//        Claims claims;
//
//        // 토큰이 있는 경우에만 관심상품 조회 가능
//        if (token != null) {
//            // Token 검증
//            if (jwtUtil.validateToken(token)) {
//                claims = jwtUtil.getUserInfoFromToken(token);
//            } else {
//                throw new CustomException(ErrorCode.INVALID_TOKEN);
//            }
//
//            // 토큰에서 가져온 사용자 정보를 사용하여 DB 조회
//            User user = userRepository.findByUsername(claims.getSubject()).orElseThrow(
//                    () -> new CustomException(ErrorCode.USER_NOT_FOUND)
//            );
//
//            Post post = postRepository.findByIdAndUsername(id, user.getUsername()).orElseThrow(
//                    () -> new CustomException(ErrorCode.UNAVAILABLE_MODIFICATION)
//            );
//            postRepository.deleteByIdAndUsername(id, user.getUsername());
//            return new MsgResponseDto("게시글 삭제 성공!!", 200);
//        } else {
//            return new MsgResponseDto("token이 존재하지 않습니다.", 404);
//        }
//    }
//
//    @Transactional
//    public List<PostSampleResponseDto> readByCategory(String category) {
//        List<Post> all = postRepository.findByCategory(category);
//        List<PostSampleResponseDto> postSampleResponseDtoList = new ArrayList<>();
//
//        for (Post posts : all) {
//            PostSampleResponseDto dto = PostSampleResponseDto.builder()
//                    .postId(posts.getId())
//                    .imageAfter(posts.getImageAfter())
//                    .title(posts.getTitle())
//                    .build();
//
//            postSampleResponseDtoList.add(dto);
//        }
//
//        return postSampleResponseDtoList;
//    }
//}
=======
@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {
    private final PostRepository postRepository;
    private final ExceptionFunctions exceptionFunctions;

    @Transactional
    public PostResponseDto create(PostRequestDto postRequestDto, User user) {
        log.info("PostService create() 실행 완");

        Post post = postRepository.saveAndFlush(new Post(postRequestDto, user.getUsername()));
        return new PostResponseDto(post);
    }

    @Transactional
    public PostResponseDto readOne(Long id, User user) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new CustomException(ErrorCode.NOT_FOUND_POST)
        );
        return new PostResponseDto(post);
    }

    @Transactional
    public PostResponseDto update(Long id, PostRequestDto postRequestDto, User user) {
        exceptionFunctions.checkPost(id);

        Post post = postRepository.findByIdAndUsername(id, user.getUsername()).orElseThrow(
                () -> new CustomException(ErrorCode.UNAVAILABLE_MODIFICATION)
        );
        post.update(postRequestDto);
        return new PostResponseDto(post);
    }

    @Transactional
    public MsgResponseDto delete(Long id, User user) {
        exceptionFunctions.checkPost(id);

        Post post = postRepository.getReferenceById(id);
        exceptionFunctions.checkOwner(post, user.getUsername());

        postRepository.deleteByIdAndUsername(id, user.getUsername());
        return new MsgResponseDto("게시글 삭제 성공!!", HttpStatus.OK.value());
    }

    @Transactional
    public List<PostSampleResponseDto> readByCategory(String category) {
        List<Post> all = postRepository.findByCategory(category);
        List<PostSampleResponseDto> postSampleResponseDtoList = new ArrayList<>();

        for (Post posts : all) {
            PostSampleResponseDto dto = PostSampleResponseDto.builder()
                    .postId(posts.getId())
                    .imageAfter(posts.getImageAfter())
                    .title(posts.getTitle())
                    .build();

            postSampleResponseDtoList.add(dto);
        }

        return postSampleResponseDtoList;
    }
}
>>>>>>> 6b5131438b1804d6691c09a45c57afd9a25bd20a
