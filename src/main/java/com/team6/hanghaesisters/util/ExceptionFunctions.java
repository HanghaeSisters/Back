package com.team6.hanghaesisters.util;

import com.team6.hanghaesisters.entity.Comment;
import com.team6.hanghaesisters.entity.Post;
import com.team6.hanghaesisters.entity.User;
import com.team6.hanghaesisters.exception.CustomException;
import com.team6.hanghaesisters.exception.ErrorCode;
import com.team6.hanghaesisters.repository.CommentRepository;
import com.team6.hanghaesisters.repository.PostRepository;
import com.team6.hanghaesisters.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExceptionFunctions{

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    //comment 코맨트 유무 확인
    public Comment getCommentByIdIfExists(Long commentId) {
        return commentRepository.findById(commentId).orElseThrow(
                () -> new CustomException(ErrorCode.NOT_FOUND_COMMENT)
        );
    }
    //comment 작성자 일치 여부
    public void checkOwner(Comment comment, Long userId) {
        if (!comment.getUserId().equals(userId)) {
            throw new CustomException(ErrorCode.UNAVAILABLE_MODIFICATION);
        }
    }
    //post 작성자 일치 여부
    public void checkOwner(Post post, String username) {
        if (!post.getUsername().equals(username)) {
            throw new CustomException(ErrorCode.UNAVAILABLE_MODIFICATION);
        }
    }
    //post 유무 확인
    public void checkPost(Long postId) {
        if (!postRepository.existsById(postId)) {
            throw new CustomException(ErrorCode.NOT_FOUND_POST);
        }
    }

    public User getUserByIdIfExists(Long userId) {
        return userRepository.findById(userId).orElseThrow(
                () -> new CustomException(ErrorCode.USER_NOT_FOUND)
        );
    }

    public void checkUser(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new CustomException(ErrorCode.INVALID_TOKEN);
        }
    }
}
