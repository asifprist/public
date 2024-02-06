package com.example.otp.entitys;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OtpEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String userIdentifier;
	private String otp;
	
	

}
