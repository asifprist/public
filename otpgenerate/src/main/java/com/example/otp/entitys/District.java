package com.example.otp.entitys;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "districts")
public class District {
    @Id
    private Long id;
    private String name;
    private Long stateId; 

}
