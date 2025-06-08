package com.example.auth_service.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.auth_service.core.BaseResponse;
import com.example.auth_service.entity.AdUser;
import com.example.auth_service.requests.LoginRequest;

public interface IAdUserService {
	BaseResponse<Optional<AdUser>> getById(UUID id);
	BaseResponse<String> login(LoginRequest request);
	Optional<AdUser> findByUsername(String username);
	void changePassword(String username, String newPassword, PasswordEncoder passwordEncoder);
}
