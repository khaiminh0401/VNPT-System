package com.example.auth_service.services;

import java.util.Optional;
import java.util.UUID;

import com.example.auth_service.core.BaseResponse;
import com.example.auth_service.entity.AdUser;

public interface IAdUserService {
	BaseResponse<Optional<AdUser>> getById(UUID id);
}
