package com.team6.hanghaesisters.service;

import com.team6.hanghaesisters.dto.MsgResponseDto;
import com.team6.hanghaesisters.dto.PostRequestDto;
import com.team6.hanghaesisters.dto.PostResponseDto;
import com.team6.hanghaesisters.dto.PostSampleResponseDto;
import com.team6.hanghaesisters.dto.post.PostDto;
import com.team6.hanghaesisters.entity.Post;
import com.team6.hanghaesisters.entity.User;
import com.team6.hanghaesisters.exception.CustomException;
import com.team6.hanghaesisters.exception.ErrorCode;
import com.team6.hanghaesisters.repository.PostRepository;
import com.team6.hanghaesisters.repository.UserRepository;
import com.team6.hanghaesisters.util.ExceptionFunctions;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {
    private final PostRepository postRepository;
    private final ExceptionFunctions exceptionFunctions;
    private final UserRepository userRepository;

    @Transactional
    public PostDto.DetailResDto create(Long userId, PostDto.CreateReqDto dto) {
        User user = getUserByIdIfExists(userId);
        Post post = dto.toEntity(user);
        return new PostDto.DetailResDto(postRepository.save(post));
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

    private User getUserByIdIfExists(Long userId) {

        return userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 회원입니다")
        );
    }
}