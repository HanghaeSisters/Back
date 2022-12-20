package com.team6.hanghaesisters.dto;

import com.team6.hanghaesisters.entity.Comment;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CommentDto {

	public record RequestDto(@NotBlank(message = "내용을 입력해주세요.")
							 @Size(min = 1, max = 200, message = "댓글은 200자 이하로 입력해주세요.")
							 String content) {
	}

	public record ResponseDto(Long commentId, String username,  String content) {

		public ResponseDto(String username, Comment comment) {
			this(comment.getId(), username, comment.getContent());
		}
	}
}
