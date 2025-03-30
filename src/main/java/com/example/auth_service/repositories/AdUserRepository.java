package com.example.auth_service.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.auth_service.core.BaseRepository;
import com.example.auth_service.entity.AdUser;

@Repository
public interface AdUserRepository extends JpaRepository<AdUser, UUID>{

}
