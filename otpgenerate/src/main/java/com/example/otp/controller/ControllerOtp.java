package com.example.otp.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.otp.entitys.OtpEntity;
import com.example.otp.ser.ServiceOtp;
@RestController
public class ControllerOtp {
	
	 @Autowired
	    private ServiceOtp otpService;
	 
	 private static final int OTP_LENGTH = 6;
	    @GetMapping("/genotp2")
	    public String generateOtp1() {
	        // OTP generation logic
	        String otp = generateRandomOtp();
	        return otp;
	    }
	    @GetMapping("/genotp")
	    //@RequestMapping(value = "/generate", method = RequestMethod.POST)
	    public OtpEntity generateOtp(@RequestParam String userIdentifier) {
	        return otpService.generateOtp(userIdentifier);
	    }
	    
         @PostMapping("/storeotp")
	   // @RequestMapping(value = "/store", method = RequestMethod.POST)
	    public OtpEntity storeOtp(@RequestParam String otp) {
	        return otpService.storeOtp(otp);
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
        @PostMapping("/otpsave")
	    public String storeOtp(@RequestParam String userIdentifier, @RequestParam String otp) {
	        // Store OTP logic, you can implement your storage logic here
	        // Example: Save the OTP in a database associated with the user
	        // You can use a service or repository to interact with your database
	        // Replace this with your actual storage logic
	        String message = "OTP for user " + userIdentifier + " stored successfully.";
	        return message;
	    }

	    private String generateRandomOtp() {
	        Random random = new Random();
	        StringBuilder otp = new StringBuilder();
	        for (int i = 0; i < OTP_LENGTH; i++) {
	            otp.append(random.nextInt(10));
	        }
	        return otp.toString();
	    }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	  
		/*
		 * @GetMapping("/otp") public boolean getotp() { boolean otp =
		 * otpService.verifyOtp("asif", 123); return otp;
		 * 
		 * }
		 
	      

	      @GetMapping("/otp1")
	      public ResponseEntity<Boolean> verifyOtp1(@RequestParam String secretKey, @RequestParam int otp) {
	          boolean otpVerified = otpService.verifyOtp(secretKey, otp);
	          if (otpVerified) {
	              return ResponseEntity.ok(true);
	          } else {
	              return ResponseEntity.status(HttpStatus.SC_BAD_REQUEST).body(false);
	          }
	      }
	      
	     
	      @PostMapping("/u")
	      public ResponseEntity<OtpEntity> storeotp(@RequestBody OtpEntity oyp){
	    	  otpService.storeOtp("java", "123");
	    	  return ResponseEntity.ok(oyp);
	   
	      }
	      */
	      
	      @PostMapping("/u")
	      public ResponseEntity<OtpEntity> storeOtp(@RequestBody OtpEntity otpEntity) {
	          // Assuming otpService is an instance of your service class
	          otpService.storeOtp(otpEntity.getOtp(), otpEntity.getUserIdentifier());

	          return ResponseEntity.ok(otpEntity);
	      }

	     @GetMapping("/generate")
		    public ResponseEntity<String> generateOtp() {
		        String secretKey = otpService.generateSecretKey();
		        return ResponseEntity.ok(secretKey);
		    }

	    @PostMapping("/verify")
	    public ResponseEntity<String> verifyOtp(@RequestParam String secretKey, @RequestParam int otp) {
	        if (otpService.verifyOtp(secretKey, otp)) {
	            return ResponseEntity.ok("OTP is valid");
	        } else {
	            return ResponseEntity.badRequest().body("OTP is not valid");
	        }
	
	    }
}
