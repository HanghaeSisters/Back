package com.team6.hanghaesisters.dto;

import com.team6.hanghaesisters.entity.Comment;
import jakarta.validation.constraints.NotBlank;

public class CommentDto {

	public record RequestDto(@NotBlank(message = "내용을 입력해주세요.")
							 String content) {
	}

	public record ResponseDto(Long commentId, String username,  String content) {

		public ResponseDto(String username, Comment comment) {
			this(comment.getId(), username, comment.getContent());
		}
	}
}
