package com.team6.hanghaesisters.dto;

import lombok.Getter;

@Getter
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
    private String msg;
}
