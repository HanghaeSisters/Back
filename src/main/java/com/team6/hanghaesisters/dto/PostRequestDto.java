package com.team6.hanghaesisters.dto;

import lombok.Getter;

@Getter
public class PostRequestDto {
    private String title;
    private String category;
    private String imageBefore;
    private String imageAfter;
    private String content;
    private int price;
    private String hospitalAddress;
    private String doctor;
}
