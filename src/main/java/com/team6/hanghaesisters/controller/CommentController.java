package com.team6.hanghaesisters.controller;

import com.team6.hanghaesisters.dto.CommentDto;
import com.team6.hanghaesisters.dto.MsgResponseDto;
import com.team6.hanghaesisters.security.UserDetailsImpl;
import com.team6.hanghaesisters.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/comment/{postId}")
    public CommentDto.ResponseDto createComment(@PathVariable Long postId, @Valid @RequestBody CommentDto.RequestDto requestDto,
        @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return commentService.createComment(postId, requestDto, userDetails.getUser());
    }

    @PutMapping("/post/{postId}/comment/{commentId}")
    public CommentDto.ResponseDto updateComment(@PathVariable Long postId, @PathVariable Long commentId,
        @Valid @RequestBody CommentDto.RequestDto requestDto,
        @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return commentService.updateComment(postId, commentId, requestDto, userDetails.getUser());
    }

    @DeleteMapping("/comment/{commentId}")
    public MsgResponseDto deleteComment(@PathVariable Long commentId, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return commentService.deleteComment(commentId, userDetails.getUser());
    }
}
