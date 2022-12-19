package com.team6.hanghaesisters.service;

import com.team6.hanghaesisters.dto.CommentDto;
import com.team6.hanghaesisters.dto.MsgResponseDto;
import com.team6.hanghaesisters.entity.Comment;
import com.team6.hanghaesisters.entity.User;
import com.team6.hanghaesisters.exception.CustomException;
import com.team6.hanghaesisters.exception.ErrorCode;
import com.team6.hanghaesisters.repository.CommentRepository;
import com.team6.hanghaesisters.repository.PostRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentService {

	private final PostRepository postRepository;
	private final CommentRepository commentRepository;

	public CommentDto.ResponseDto createComment(Long postId, CommentDto.RequestDto requestDto,
		User user) {

		checkPost(postId);

		Comment comment = new Comment();  //commentRequestDto.getContent(), postId, userId -> 매개 변수
		commentRepository.save(comment);

		return new CommentDto.ResponseDto(comment);    //String username
		return null;
	}

	public CommentDto.ResponseDto updateComment(Long postId, Long commentId,
		CommentDto.RequestDto requestDto,
		User user) {

		checkPost(postId);
		Comment comment = getCommentByIdIfExists(commentId);
		checkOwner(comment);  //user.getUserId();

		comment.update(requestDto.content());

		return new CommentDto.ResponseDto(comment);   //String username

		return null;
	}

	public MsgResponseDto deleteComment(Long commentId, User user) {
		Comment comment = getCommentByIdIfExists(commentId);
//		checkOwner(comment, userId);

		commentRepository.deleteById(commentId);

		return new MsgResponseDto("댓글 삭제 성공!", HttpStatus.OK.value());
	}

	private void checkPost(Long postId) {
		if (!postRepository.existsById(postId)) {
			throw new CustomException(ErrorCode.NOT_FOUND_POST);
		}
	}

	private void checkOwner(Comment comment, Long userId) {
		if (!comment.getUserId().equals(userId)) {
			throw new CustomException(ErrorCode.UNAVAILABLE_MODIFICATION);
		}
	}

	private Comment getCommentByIdIfExists(Long commentId) {
		return commentRepository.findById(commentId).orElseThrow(
			() ->new CustomException(ErrorCode.NOT_FOUND_COMMENT)
		);
	}
}