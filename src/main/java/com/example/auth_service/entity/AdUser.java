package com.example.auth_service.entity;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity()
public class AdUser {
	@Id()
	@Column()
	public UUID id;
	
	@Column(columnDefinition = "text",nullable = true)
	public String username;
	
	@Column(columnDefinition = "TEXT",nullable = true)
	public String password;
	
	@Column(nullable = true)
	public Date thoi_gian_tao;
	
	@Column(columnDefinition = "TEXT",nullable = true)
	public String nguoi_tao;
	
	@Column(nullable = true)
	public Date thoi_gian_cap_nhat;
	
	@Column(columnDefinition = "TEXT",nullable = true)
	public String nguoi_cap_nhat;
	
	@Column(nullable = true)
	public Date thoi_gian_xoa;
	
	@Column(columnDefinition = "TEXT",nullable = true)
	public String nguoi_xoa;
}
