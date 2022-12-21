package com.team6.hanghaesisters.entity;

import com.team6.hanghaesisters.dto.PostRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Post extends TimeStamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String imageBefore;

    @Column(nullable = false)
    private String imageAfter;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private String hospitalAddress;

    @Column(nullable = false)
    private String doctor;

    public Post(PostRequestDto postRequestDto, String username) {
        this.username = username;
        this.title = postRequestDto.getTitle();
        this.category = postRequestDto.getCategory();
        this.imageBefore = postRequestDto.getImageBefore();
        this.imageAfter = postRequestDto.getImageAfter();
        this.content = postRequestDto.getContent();
        this.price = postRequestDto.getPrice();
        this.hospitalAddress = postRequestDto.getHospitalAddress();
        this.doctor = postRequestDto.getDoctor();
    }

    public void update(PostRequestDto postRequestDto) {
        this.title = postRequestDto.getTitle();
        this.category = postRequestDto.getCategory();
        this.imageBefore = postRequestDto.getImageBefore();
        this.imageAfter = postRequestDto.getImageAfter();
        this.content = postRequestDto.getContent();
        this.price = postRequestDto.getPrice();
        this.hospitalAddress = postRequestDto.getHospitalAddress();
        this.doctor = postRequestDto.getDoctor();
    }
}
