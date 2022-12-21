package com.team6.hanghaesisters.dto;

import com.team6.hanghaesisters.entity.Comment;
import com.team6.hanghaesisters.entity.Post;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PostResponseDto {
    private Long id;
    //httpHeader
    private String username;
    private String title;
    private String category;
    private String imageBefore;
    private String imageAfter;
    private String content;
    private int price;
    private String hospitalAddress;
    private String doctor;
    //    private String msg;
    private List<Comment> comments;

    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.username = post.getUsername();
        this.title = post.getTitle();
        this.category = post.getCategory();
        this.imageAfter = post.getImageAfter();
        this.imageBefore = post.getImageBefore();
        this.content = post.getContent();
        this.price = post.getPrice();
        this.hospitalAddress = post.getHospitalAddress();
        this.doctor = post.getDoctor();
    }

    public PostResponseDto(Post post, List<Comment> comments) {
        this.id = post.getId();
        this.username = post.getUsername();
        this.title = post.getTitle();
        this.category = post.getCategory();
        this.imageAfter = post.getImageAfter();
        this.imageBefore = post.getImageBefore();
        this.content = post.getContent();
        this.price = post.getPrice();
        this.hospitalAddress = post.getHospitalAddress();
        this.doctor = post.getDoctor();
        this.comments = comments;
    }
}
