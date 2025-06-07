package com.example.auth_service.controller;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.auth_service.core.BaseResponse;
import com.example.auth_service.entity.AdUser;
import com.example.auth_service.requests.LoginRequest;
import com.example.auth_service.services.IAdUserService;
import com.example.auth_service.utils.JwtUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/auth")
public class AuthController {

	private final IAdUserService adUserService;

    private final AuthenticationManager authenticationManager;

    private final JwtUtil jwtUtil;

    private final UserDetailsService userDetailsService;

	public AuthController(
		IAdUserService _adUserService,
		UserDetailsService _userDetailsService,
		JwtUtil _jwtUtil,
		AuthenticationManager _authenticationManager
	) {
		this.adUserService = _adUserService;
		this.userDetailsService = _userDetailsService;
		this.jwtUtil = _jwtUtil;
		this.authenticationManager = _authenticationManager;
	}

	@GetMapping("/{id}")
	@Operation(summary = "Lấy thông tin người dùng theo ID", description = "Truy xuất người dùng từ database bằng UUID.", tags = {
			"User" })
	public BaseResponse<Optional<AdUser>> getById(
			@Parameter(description = "UUID của người dùng", required = true) @PathVariable(name = "id", required = true) UUID id) {
		return this.adUserService.getById(id);
	}

	@PostMapping("/login")
	@Operation(summary = "API đăng nhập", description = "Xác thực người dùng và trả về thông tin người dùng nếu thành công.", tags = {
			"User" })
	public BaseResponse<String> login(
			@RequestBody LoginRequest request) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

		final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
		final String jwt = jwtUtil.generateToken(userDetails);
		System.out.println("JWT Token: " + jwt);
		System.out.println("Login request: " + request.username + ", " + request.password);
		return this.adUserService.login(request);
	}
}
