package com.campusVirtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campusVirtual.model.UserCredentials;

public interface UserCredentialsRepository extends JpaRepository<UserCredentials,Long>{
    
}
