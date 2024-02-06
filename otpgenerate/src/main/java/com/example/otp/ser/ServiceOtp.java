package com.example.otp.ser;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.example.otp.entitys.OtpEntity;
import com.example.otp.repo.OtpRepository;
import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;
@Service

public class ServiceOtp implements OtpRepository{
	
	
	@Autowired
	private OtpRepository otprepo;
	
	   private static final int OTP_LENGTH = 6;

	    public String generateOtp() {
	        Random random = new Random();
	        StringBuilder otp = new StringBuilder();

	        for (int i = 0; i < OTP_LENGTH; i++) {
	            otp.append(random.nextInt(10)); // Generates random digits (0-9)
	        }

	        return otp.toString();
	    }
	    
	    // Store the generated OTP and associate it with a user, e.g., in a database.
	     public void storeOtp(String userIdentifier, String otp) {
	     long count = otprepo.count();
	     return;
	        // Implement your storage logic here
	    }
	
	  public String generateSecretKey() {
	        GoogleAuthenticator gAuth = new GoogleAuthenticator();
	        GoogleAuthenticatorKey key = gAuth.createCredentials();
	        return key.getKey();
	    }
	    
	    public boolean verifyOtp(String secretKey, int otp) {
	        GoogleAuthenticator gAuth = new GoogleAuthenticator();
	        return gAuth.authorize(secretKey, otp);
	    }

	//generate otp
		@Override
		public OtpEntity generateOtp(String userIdentifier) {
			OtpEntity otpgen2 = otprepo.generateOtp(userIdentifier);
			return otpgen2;
		}

		@Override
		public OtpEntity storeOtp(String otp) {
		OtpEntity otp2 = otprepo.storeOtp(otp);
			return otp2;
		}

		@Override
		public void flush() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public <S extends OtpEntity> S saveAndFlush(S entity) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends OtpEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void deleteAllInBatch(Iterable<OtpEntity> entities) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteAllByIdInBatch(Iterable<String> ids) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteAllInBatch() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public OtpEntity getOne(String id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public OtpEntity getById(String id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public OtpEntity getReferenceById(String id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends OtpEntity> List<S> findAll(Example<S> example) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends OtpEntity> List<S> findAll(Example<S> example, Sort sort) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends OtpEntity> List<S> saveAll(Iterable<S> entities) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<OtpEntity> findAll() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<OtpEntity> findAllById(Iterable<String> ids) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends OtpEntity> S save(S entity) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Optional<OtpEntity> findById(String id) {
			// TODO Auto-generated method stub
			return Optional.empty();
		}

		@Override
		public boolean existsById(String id) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public long count() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void deleteById(String id) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void delete(OtpEntity entity) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteAllById(Iterable<? extends String> ids) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteAll(Iterable<? extends OtpEntity> entities) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteAll() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public List<OtpEntity> findAll(Sort sort) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Page<OtpEntity> findAll(Pageable pageable) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends OtpEntity> Optional<S> findOne(Example<S> example) {
			// TODO Auto-generated method stub
			return Optional.empty();
		}

		@Override
		public <S extends OtpEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends OtpEntity> long count(Example<S> example) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public <S extends OtpEntity> boolean exists(Example<S> example) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public <S extends OtpEntity, R> R findBy(Example<S> example,
				Function<FetchableFluentQuery<S>, R> queryFunction) {
			// TODO Auto-generated method stub
			return null;
		}

	
	}


