package com.team6.hanghaesisters.dto.post;

import com.team6.hanghaesisters.entity.Post;
import com.team6.hanghaesisters.entity.User;

public class PostDto {
    public record CreateReqDto(String username, String title, String category, String imageBefore, String imageAfter,
                               String content, int price, String hospitalAddress, String doctor) {
        public Post toEntity(User user) {
            return new Post(user, this.username,
                    this.title,
                    this.category,
                    this.imageBefore,
                    this.imageAfter,
                    this.content,
                    this.price,
                    this.hospitalAddress,
                    this.doctor);
        }
    }

    public record DetailResDto(Long id, String title, String content, String username) {

        public DetailResDto(Post post){
            this(post.getId(), post.getTitle(), post.getContent(), post.getUser().getUsername());
        }

    }

}

