package com.campusVirtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campusVirtual.model.AuthCredentials;

public interface AuthCredentialsRepository extends JpaRepository<AuthCredentials,Long>{
    
}
