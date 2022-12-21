package com.team6.hanghaesisters.dto;

import com.team6.hanghaesisters.entity.Post;
import java.util.List;
import lombok.Builder;

public class PostDto {

	public record RequestDto(String title, String category, String imageBefore, String imageAfter,
							 String content, int price, String hospitalAddress, String doctor) {
	}

	public record CreateResponseDto(Long postId, String username, String title, String category,
							  String imageBefore, String imageAfter, String content,
							  int price, String hospitalAddress, String doctor) {

		public CreateResponseDto(Post post) {
			this(post.getId(), post.getUsername(), post.getTitle(), post.getCategory(), post.getImageAfter(),
				post.getImageBefore(), post.getContent(), post.getPrice(), post.getHospitalAddress(), post.getDoctor());
		}

	}

	public record AllResponseDto(Long postId, String username, String title, String category,
									String imageBefore, String imageAfter, String content,
									int price, String hospitalAddress, String doctor,
								 List<CommentDto.ResponseDto> commentList) {

		public AllResponseDto(Post post, CommentDto.ResponseListDto commentList) {
			this(post.getId(), post.getUsername(), post.getTitle(), post.getCategory(), post.getImageAfter(),
				post.getImageBefore(), post.getContent(), post.getPrice(), post.getHospitalAddress(), post.getDoctor(),
				commentList.commentList());
		}
	}

	@Builder
	public record PreviewResponseDto(Long postId, String imageAfter, String title, int price) {

	}
}
