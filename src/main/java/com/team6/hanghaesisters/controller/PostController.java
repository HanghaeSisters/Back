package com.team6.hanghaesisters.controller;

import com.team6.hanghaesisters.dto.MsgResponseDto;
import com.team6.hanghaesisters.dto.PostRequestDto;
import com.team6.hanghaesisters.dto.PostResponseDto;
import com.team6.hanghaesisters.entity.Post;
import com.team6.hanghaesisters.service.PostService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/post")
@Slf4j
public class PostController {

    private final PostService postService;

    //글 작성
    @PostMapping("")
    public PostResponseDto createPost(@RequestBody PostRequestDto postRequestDto, HttpServletRequest request){
        log.info("controller-createPost메소드 실행 완");
        return postService.create(postRequestDto, request);
    }

    //글 수정
    @PutMapping("/{id}")
    public PostResponseDto readOnePost(@PathVariable Long id, HttpServletRequest request) {
        return postService.readOne(id, request);
    }

    //글 조회
    @GetMapping("/{id}")
    public PostResponseDto updatePost(@PathVariable Long id, @RequestBody PostRequestDto postRequestDto, HttpServletRequest request){
        return postService.update(id, postRequestDto, request);
    }
    //글 삭제
    @DeleteMapping("/{id}")
    public MsgResponseDto deletePost(@PathVariable Long id, HttpServletRequest request){
        return postService.delete(id, request);
    }

}





