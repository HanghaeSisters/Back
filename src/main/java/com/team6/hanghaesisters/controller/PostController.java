package com.team6.hanghaesisters.controller;

import com.team6.hanghaesisters.dto.MsgResponseDto;
import com.team6.hanghaesisters.dto.PostRequestDto;
import com.team6.hanghaesisters.dto.PostResponseDto;
import com.team6.hanghaesisters.dto.PostSampleResponseDto;
<<<<<<< HEAD
import com.team6.hanghaesisters.entity.Post;
//import com.team6.hanghaesisters.service.PostService;
=======
import com.team6.hanghaesisters.security.UserDetailsImpl;
import com.team6.hanghaesisters.service.PostService;
>>>>>>> 6b5131438b1804d6691c09a45c57afd9a25bd20a
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

<<<<<<< HEAD
//@RequiredArgsConstructor
//@RestController
//@RequestMapping("/api/post")
//@Slf4j
//public class PostController {
//
//    private final PostService postService;
//
//    //글 작성
//    @PostMapping("")
//    public PostResponseDto createPost(@RequestBody PostRequestDto postRequestDto, HttpServletRequest request){
//        log.info("controller-createPost메소드 실행 완");
//        return postService.create(postRequestDto, request);
//    }
//
//    //글 조회
//    @GetMapping("/{id}")
//    public PostResponseDto readOnePost(@PathVariable Long id, HttpServletRequest request) {
//        return postService.readOne(id, request);
//    }
//
//    //글 수정
//    @PutMapping("/{id}")
//    public PostResponseDto updatePost(@PathVariable Long id, @RequestBody PostRequestDto postRequestDto, HttpServletRequest request){
//        return postService.update(id, postRequestDto, request);
//    }
//    //글 삭제
//    @DeleteMapping("/{id}")
//    public MsgResponseDto deletePost(@PathVariable Long id, HttpServletRequest request){
//        return postService.delete(id, request);
//    }
//
////    @RequestParam
//    @GetMapping("/category")
//    public List<PostSampleResponseDto> readPostByCategory(@RequestParam("category") String category) {
//        return postService.readByCategory(category);
//    }
//}
=======
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
>>>>>>> 6b5131438b1804d6691c09a45c57afd9a25bd20a





