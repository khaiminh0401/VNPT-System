package com.example.auth_service.controller;

import java.util.Optional;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.auth_service.core.BaseResponse;
import com.example.auth_service.entity.AdUser;
import com.example.auth_service.services.IAdUserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	private final IAdUserService adUserService;
	
	public AuthController(IAdUserService _adUserService) {
		this.adUserService = _adUserService;
	}

	@GetMapping("/{id}")
	@Operation(
		    summary = "Lấy thông tin người dùng theo ID",
		    description = "Truy xuất người dùng từ database bằng UUID.",
		    tags = {"User"}
		)
	public BaseResponse<Optional<AdUser>> getById(
			@Parameter(description = "UUID của người dùng", required = true)
		    @PathVariable(name = "id", required = true) UUID id
		) 	{
		return this.adUserService.getById(id);
	}
}
