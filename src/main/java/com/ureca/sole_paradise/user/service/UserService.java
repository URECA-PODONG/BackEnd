package com.ureca.sole_paradise.user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.ureca.sole_paradise.user.db.dto.UserResponseDTO;
import com.ureca.sole_paradise.user.db.entity.UserEntity;
import com.ureca.sole_paradise.user.db.repository.UserRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
	
	private final UserRepository userRepo;
	
	
	public UserResponseDTO getUserInfo(int userId) {
		
		
		UserEntity userEntity = userRepo.findById(userId).get();
		
		UserResponseDTO userResDTO= new UserResponseDTO();
		
		userResDTO.setBuyer_addr(userEntity.getAddress());
		userResDTO.setBuyer_email(userEntity.getAccountEmail());
		userResDTO.setBuyer_name(userEntity.getProfileNickname());
		userResDTO.setBuyer_tel(userEntity.getPhoneNumber());
		
		return userResDTO;
		
	}

}
