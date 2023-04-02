package com.campusVirtual.service;


import com.campusVirtual.dto.UserRegisterDto;
import com.campusVirtual.model.Userdata;


public interface IUserDataService {
    public Userdata getUserById(String username);

    public UserRegisterDto getUserDataDtoByContext();

    public Userdata saveUser(Userdata user);

    public Boolean existsUserById(String userId);
}
