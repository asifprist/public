package com.example.otp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.otp.entitys.OtpEntity;
@Repository
public interface OtpRepository extends JpaRepository<OtpEntity, String>{
	
      OtpEntity generateOtp(@RequestParam String userIdentifier);	
      OtpEntity storeOtp(@RequestParam String otp);

}
