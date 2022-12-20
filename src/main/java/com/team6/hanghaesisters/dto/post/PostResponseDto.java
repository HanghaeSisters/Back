package com.team6.hanghaesisters.dto.post;

import com.team6.hanghaesisters.entity.Post;
import lombok.Getter;

@Getter
public static class PostResponseDto {
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
}

