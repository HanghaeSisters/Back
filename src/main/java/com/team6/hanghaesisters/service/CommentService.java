package com.team6.hanghaesisters.service;

import com.team6.hanghaesisters.dto.CommentDto;
import com.team6.hanghaesisters.dto.MsgResponseDto;
import com.team6.hanghaesisters.entity.Comment;
import com.team6.hanghaesisters.entity.User;
import com.team6.hanghaesisters.exception.CustomException;
import com.team6.hanghaesisters.exception.ErrorCode;
import com.team6.hanghaesisters.repository.CommentRepository;
import com.team6.hanghaesisters.repository.PostRepository;
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

		//게시글 존재여부 확인
		checkPost(postId);

		Comment comment = new Comment(requestDto.content(), postId, user.getId());
		commentRepository.save(comment);

		return new CommentDto.ResponseDto(comment, user.getUsername());
	}

	public CommentDto.ResponseDto updateComment(Long postId, Long commentId,
		CommentDto.RequestDto requestDto, User user) {

		//게시글 존재여부 확인
		checkPost(postId);

		//댓글 존재여부 확인 후 가져오기
		Comment comment = getCommentByIdIfExists(commentId);

		//댓글 작성자가 맞는지 확인
		checkOwner(comment, user.getId());

		comment.update(requestDto.content());

		return new CommentDto.ResponseDto(comment, user.getUsername());
	}

	public MsgResponseDto deleteComment(Long commentId, User user) {
		//댓글 존재여부 확인 후 가져오기
		Comment comment = getCommentByIdIfExists(commentId);

		//댓글 작성자가 맞는지 확인
		checkOwner(comment, user.getId());

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
			() -> new CustomException(ErrorCode.NOT_FOUND_COMMENT)
		);
	}
}