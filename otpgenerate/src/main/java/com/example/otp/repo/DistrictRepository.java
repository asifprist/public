package com.example.otp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.otp.entitys.District;

public interface DistrictRepository extends JpaRepository<District, Long> {
    List<District> findByStateId(Long stateId);
}
