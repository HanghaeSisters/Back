package com.team6.hanghaesisters.service;

import com.team6.hanghaesisters.dto.MsgResponseDto;
import com.team6.hanghaesisters.dto.PostRequestDto;
import com.team6.hanghaesisters.dto.PostResponseDto;
import com.team6.hanghaesisters.repository.PostRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public PostResponseDto create(PostRequestDto postRequestDto, HttpServletRequest request){
        String token = jwtUtil.resolveToken(request);
        return null;
    };

    public PostResponseDto readOne(Long id, HttpServletRequest request){
        return null;
    }

    public PostResponseDto update(Long id, PostRequestDto postRequestDto, HttpServletRequest request){
        return null;
    }

    public MsgResponseDto delete(Long id, HttpServletRequest request) {
        return null;
    }
}
