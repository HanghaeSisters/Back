package com.team6.hanghaesisters.entity;

import com.team6.hanghaesisters.dto.PostRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
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

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Post(User user, String username, String title, String category, String imageBefore, String imageAfter,
                String content, int price, String hospitalAddress, String doctor) {
        this.username = username;
        this.title = title;
        this.category = category;
        this.imageBefore = imageBefore;
        this.imageAfter = imageAfter;
        this.content = content;
        this.price = price;
        this.hospitalAddress = hospitalAddress;
        this.doctor = doctor;
        this.user = user;
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
