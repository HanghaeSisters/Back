package com.team6.hanghaesisters.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class PostSampleResponseDto {
    private Long postId;
    private String imageAfter;
    private String title;
}
