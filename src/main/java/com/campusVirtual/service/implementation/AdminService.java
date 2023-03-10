package com.campusVirtual.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusVirtual.model.UserCredentials;
import com.campusVirtual.repository.UserCredentialsRepository;
import com.campusVirtual.service.IAdminService;

@Service
public class AdminService implements IAdminService{

    @Autowired
    private UserCredentialsRepository uCredentialsRepository;

    @Override
    public void asignarRoleUser(String role, Long id) {
        UserCredentials uc = this.uCredentialsRepository.findById(id).get();
        uc.addAuthorities(role);
        this.uCredentialsRepository.save(uc);
    }

}