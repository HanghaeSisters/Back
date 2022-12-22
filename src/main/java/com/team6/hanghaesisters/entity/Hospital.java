package com.team6.hanghaesisters.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Pattern(regexp = "^[가-힣|0-9|a-z|A-Z]+$", message = "띄워쓰기는 입력이 불가능하며, 한글만 입력이 가능합니다.")
    @NotBlank(message = "병원 정보를 입력하지 않았습니다.")
    private String hospitalName;

    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
    }
}
