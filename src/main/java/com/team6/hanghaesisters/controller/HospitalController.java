package com.team6.hanghaesisters.controller;

import com.team6.hanghaesisters.service.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HospitalController {

    private final HospitalService hospitalService;

    @PostMapping("/api/hospital/save-all")
    public String HospitalApiSave() {
        return hospitalService.saveHospitalApiData();
    }
}
