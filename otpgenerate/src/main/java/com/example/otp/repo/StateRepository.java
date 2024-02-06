package com.example.otp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.otp.entitys.State;

public interface StateRepository extends JpaRepository<State, Long> {
}
