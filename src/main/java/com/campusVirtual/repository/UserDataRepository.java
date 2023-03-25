package com.campusVirtual.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campusVirtual.model.Userdata;

public interface UserDataRepository extends JpaRepository<Userdata,String>{
    
}
