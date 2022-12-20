package com.team6.hanghaesisters.controller;

import com.team6.hanghaesisters.dto.MsgResponseDto;
import com.team6.hanghaesisters.dto.PostRequestDto;
import com.team6.hanghaesisters.dto.PostResponseDto;
import com.team6.hanghaesisters.dto.PostSampleResponseDto;
import com.team6.hanghaesisters.security.UserDetailsImpl;
import com.team6.hanghaesisters.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/post")
@Slf4j
public class PostController {
    private final PostService postService;

    //글 작성
    @PostMapping("")
    public PostResponseDto createPost(@RequestBody PostRequestDto postRequestDto,
                                      @AuthenticationPrincipal UserDetailsImpl userDetails){
        log.info("UserDetails:" + userDetails);
        return postService.create(postRequestDto, userDetails.getUser());
    }

    //글 조회
    @GetMapping("/{id}")
    public PostResponseDto readOnePost(@PathVariable Long id,
                                       @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return postService.readOne(id, userDetails.getUser());
    }

    //글 수정
    @PutMapping("/{id}")
    public PostResponseDto updatePost(@PathVariable Long id, @RequestBody PostRequestDto postRequestDto,
                                      @AuthenticationPrincipal UserDetailsImpl userDetails){
        return postService.update(id, postRequestDto, userDetails.getUser());
    }
    //글 삭제
    @DeleteMapping("/{id}")
    public MsgResponseDto deletePost(@PathVariable Long id, @AuthenticationPrincipal UserDetailsImpl userDetails){
        return postService.delete(id, userDetails.getUser());
    }

//    @RequestParam
    @GetMapping("/category")
    public List<PostSampleResponseDto> readPostByCategory(@RequestParam("category") String category) {
        return postService.readByCategory(category);
    }

}





