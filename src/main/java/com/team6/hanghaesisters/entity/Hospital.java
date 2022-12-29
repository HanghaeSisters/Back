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
    private String hospitalName;

    @Column
    private String hospitalKey;

    public Hospital(String hospitalName, String hospitalKey) {
        this.hospitalName = hospitalName;
        this.hospitalKey = hospitalKey;
    }
}
