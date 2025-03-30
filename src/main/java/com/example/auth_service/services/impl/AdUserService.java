package com.example.auth_service.services.impl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.auth_service.core.BaseResponse;
import com.example.auth_service.entity.AdUser;
import com.example.auth_service.repositories.AdUserRepository;
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
}
