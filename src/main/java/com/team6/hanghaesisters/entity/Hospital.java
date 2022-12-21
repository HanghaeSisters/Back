package com.team6.hanghaesisters.entity;

import jakarta.persistence.*;
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
    private String hospitalName;

    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
    }
}
