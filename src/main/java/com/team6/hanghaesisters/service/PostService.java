package com.team6.hanghaesisters.service;

import com.team6.hanghaesisters.dto.MsgResponseDto;
import com.team6.hanghaesisters.dto.PostRequestDto;
import com.team6.hanghaesisters.dto.PostResponseDto;
import com.team6.hanghaesisters.dto.PostSampleResponseDto;
import com.team6.hanghaesisters.entity.Comment;
import com.team6.hanghaesisters.entity.Post;
import com.team6.hanghaesisters.entity.User;
import com.team6.hanghaesisters.exception.CustomException;
import com.team6.hanghaesisters.exception.ErrorCode;
import com.team6.hanghaesisters.repository.CommentRepository;
import com.team6.hanghaesisters.repository.PostRepository;
import com.team6.hanghaesisters.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    @Transactional
    public PostResponseDto create(PostRequestDto postRequestDto, Long userId) {
        log.info("PostService create() 실행 완");

        User user = getUserByIdIfExists(userId);
        Post post = postRepository.saveAndFlush(new Post(postRequestDto, user.getUsername()));
        return new PostResponseDto(post);
    }

    @Transactional(readOnly = true)
    public PostResponseDto readOne(Long id, Long userId) {
        checkUser(userId);

        Post post = postRepository.findById(id).orElseThrow(
                () -> new CustomException(ErrorCode.NOT_FOUND_POST)
        );
        return new PostResponseDto(post);
    }

    @Transactional
    public PostResponseDto update(Long id, PostRequestDto postRequestDto, Long userId) {
        checkPost(id);

        User user = getUserByIdIfExists(userId);

        Post post = postRepository.findByIdAndUsername(id, user.getUsername()).orElseThrow(
                () -> new CustomException(ErrorCode.UNAVAILABLE_MODIFICATION)
        );
        post.update(postRequestDto);
        return new PostResponseDto(post);
    }

    @Transactional
    public MsgResponseDto delete(Long id, Long userId) {
        checkPost(id);

        User user = getUserByIdIfExists(userId);

        Post post = postRepository.getReferenceById(id);
        checkOwner(post, user.getUsername());

        postRepository.deleteByIdAndUsername(id, user.getUsername());
        return new MsgResponseDto("게시글 삭제 성공!!", HttpStatus.OK.value());
    }

    @Transactional(readOnly = true)
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

    public User getUserByIdIfExists(Long userId) {
        return userRepository.findById(userId).orElseThrow(
                () -> new CustomException(ErrorCode.USER_NOT_FOUND)
        );
    }

    //post 유무 확인
    public void checkPost(Long postId) {
        if (!postRepository.existsById(postId)) {
            throw new CustomException(ErrorCode.NOT_FOUND_POST);
        }
    }

    //comment 코맨트 유무 확인
    public Comment getCommentByIdIfExists(Long commentId) {
        return commentRepository.findById(commentId).orElseThrow(
                () -> new CustomException(ErrorCode.NOT_FOUND_COMMENT)
        );
    }

    public void checkOwner(Post post, String username) {
        if (!post.getUsername().equals(username)) {
            throw new CustomException(ErrorCode.UNAVAILABLE_MODIFICATION);
        }
    }

    public void checkUser(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new CustomException(ErrorCode.INVALID_TOKEN);
        }
    }
}