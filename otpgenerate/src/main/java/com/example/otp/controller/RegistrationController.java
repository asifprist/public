package com.example.otp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.otp.entitys.District;
import com.example.otp.entitys.State;
import com.example.otp.repo.DistrictRepository;
import com.example.otp.repo.StateRepository;

@RestController
@RequestMapping("/api")
public class RegistrationController {
    private final StateRepository stateRepository;
    private final DistrictRepository districtRepository;

    public RegistrationController(StateRepository stateRepository, DistrictRepository districtRepository) {
        this.stateRepository = stateRepository;
        this.districtRepository = districtRepository;
    }

    @GetMapping("/states")
    public List<State> getStates() {
        return stateRepository.findAll();
    }

    @GetMapping("/districts")
    public List<District> getDistricts(@RequestParam Long stateId) {
        return districtRepository.findByStateId(stateId);
    }
}
