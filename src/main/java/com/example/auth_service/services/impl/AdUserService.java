package com.example.auth_service.services.impl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.auth_service.core.BaseResponse;
import com.example.auth_service.entity.AdUser;
import com.example.auth_service.repositories.AdUserRepository;
import com.example.auth_service.requests.LoginRequest;
import com.example.auth_service.services.IAdUserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdUserService implements IAdUserService{
	private final AdUserRepository adUserRepository;

	@Override
	public BaseResponse<Optional<AdUser>> getById(UUID id) {
		// TODO Auto-generated method stub
		var adUser = adUserRepository.findById(id);
		return BaseResponse.success(adUser);
	}

	@Override
	public BaseResponse<String> login(LoginRequest request) {
		// Đăng nhập đã được xác thực ở controller bằng authenticationManager
		return BaseResponse.success("Login successful");
	}
	@Override
	public Optional<AdUser> findByUsername(String username) {
        return adUserRepository.findByUsername(username);
    }
	
	@Override
	public void changePassword(String username, String newPassword, PasswordEncoder passwordEncoder) {
		Optional<AdUser> userOpt = adUserRepository.findByUsername(username);
		if (userOpt.isPresent()) {
			AdUser user = userOpt.get();
			user.password = passwordEncoder.encode(newPassword);
			adUserRepository.save(user);
		}
	}
}
