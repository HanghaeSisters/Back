package com.team6.hanghaesisters.dto.post;

import java.util.List;

public class PostDto {

    public record CreateReqDto(@Size(min = 2, max = 20, message = "제목은 2자 이상, 20자 이하로 입력해 주세요") String title,
                               @Size(min = 1, max = 255, message = "제목은 1자 이상, 255자 이하로 입력해 주세요") String content) {

        public Post toEntity(User user) {
            return new Post(user, this.title, this.content);
        }

    }

    public record UpdateReqDto(@Size(min = 2, max = 20, message = "제목은 2자 이상, 20자 이하로 입력해 주세요") String title,
                               @Size(min = 1, max = 255, message = "제목은 1자 이상, 255자 이하로 입력해 주세요")String content) {

    }

    public record DetailResDto(Long id, String title, String content, String nickname) {

        public DetailResDto(Post post){
            this(post.getId(), post.getTitle(), post.getContents(), post.getUser().getNickname());
        }

    }

    public record AllResDto(List<SimpleResDto> postList) {

    }

    public record SimpleResDto(Long id, String title, String nickname) {

        public SimpleResDto(Post post) {
            this(post.getId(), post.getTitle(), post.getUser().getNickname());
        }
    }

}

