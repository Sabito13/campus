package com.campusVirtual.service;


import com.campusVirtual.model.Userdata;


public interface IUserDataService {
    public Userdata getUserById(String username);

    public Userdata saveUser(Userdata user);
}
