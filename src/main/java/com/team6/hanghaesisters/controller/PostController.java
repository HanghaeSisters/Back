package com.team6.hanghaesisters.controller;

import com.team6.hanghaesisters.dto.MsgResponseDto;
import com.team6.hanghaesisters.dto.PostRequestDto;
import com.team6.hanghaesisters.dto.PostResponseDto;
import com.team6.hanghaesisters.entity.Post;
import com.team6.hanghaesisters.service.PostService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post")
public class PostController {

    private final PostService postService;

    //글 작성
    @PostMapping
    public PostResponseDto createPost(@RequestBody PostRequestDto postRequestDto, HttpServletRequest request){
        return postService.create(postRequestDto, request);
    }

    //글 수정
    @PutMapping("{id}")
    public PostResponseDto readOnePost(@PathVariable Long id, HttpServletRequest request) {
        return postService.readOne(id, request);
    }

    //글 조회
    @GetMapping("{id}")
    public PostResponseDto updatePost(@PathVariable Long id, @RequestBody PostRequestDto postRequestDto, HttpServletRequest request){
        return postService.update(id, postRequestDto, request);
    }
    //글 삭제
    @DeleteMapping("{id}")
    public MsgResponseDto deletePost(@PathVariable Long id, HttpServletRequest request){
        return postService.delete(id, request);
    }

}
