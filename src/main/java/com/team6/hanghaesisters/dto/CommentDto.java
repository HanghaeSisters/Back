package com.team6.hanghaesisters.dto;

import com.team6.hanghaesisters.entity.Comment;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.List;

public class CommentDto {

	public record RequestDto(@NotBlank(message = "내용을 입력해주세요.")
							 @Size(min = 1, max = 200, message = "댓글은 200자로 입력해주세요.")
							 String content) {
	}

	public record ResponseDto(Long commentId, String content, String username) {

		public ResponseDto(Comment comment, String username) {
			this(comment.getId(), comment.getContent(), username);
		}
	}

	public record AllResponseDto(List<ResponseDto> commentList) {

	}
}
