package com.example.otp.entitys;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "states")
public class State {
    @Id
    private Long id;
    private String name;

    // Getters and setters
}
