package com.campusVirtual.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.campusVirtual.dto.UserRegisterDto;
import com.campusVirtual.exception.ObjectNotFoundException;
import com.campusVirtual.model.Userdata;
import com.campusVirtual.repository.UserDataRepository;
import com.campusVirtual.service.IUserDataService;

@Service
public class UserDataService implements IUserDataService {

    @Autowired
    private UserDataRepository userRepository;

    @Override
    public Userdata getUserById(String username) {
        return this.userRepository.findById(username).orElseThrow(()-> new ObjectNotFoundException("User",username));
    }

    @Override
    public Userdata saveUser(Userdata user) {
        return this.userRepository.save(user);
    }

    @Override
    public Boolean existsUserById(String userId) {
        return this.userRepository.existsById(userId);
    }

    @Override
    public UserRegisterDto getUserDataDtoByContext() {

        String username= SecurityContextHolder.getContext().getAuthentication().getName();
                
        Userdata  user= this.getUserById(username);
        
        UserRegisterDto userRegistered = new UserRegisterDto();


        userRegistered.setUsername(user.getUsername());
        userRegistered.setName(user.getName());
        userRegistered.setLastName(user.getLastName());
        userRegistered.setMail(user.getMail());
        userRegistered.setRole(user.getAuthorities());

        return userRegistered;

    }
    
}
