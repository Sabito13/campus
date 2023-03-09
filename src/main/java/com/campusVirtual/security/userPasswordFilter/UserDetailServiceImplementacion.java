package com.campusVirtual.security.userPasswordFilter;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.campusVirtual.model.AuthCredentials;
import com.campusVirtual.repository.AuthCredentialsRepository;

import com.campusVirtual.exception.AlumnoNotFoundException;

@Service
public class UserDetailServiceImplementacion implements UserDetailsService{

    @Autowired
    private AuthCredentialsRepository authCredentialsRepository;

    @Override
    public UserDetails loadUserByUsername(String dniString) throws UsernameNotFoundException { 
        Long dni = Long.parseLong(dniString); 
        AuthCredentials  UserAuth = this.authCredentialsRepository.findById(dni).orElseThrow(()-> new AlumnoNotFoundException(dni));
        //AuthCredentials  UserAuth = new AuthCredentials(dni, "juan","a");
        return new UserDetailsImplementacion(UserAuth);
    }
    
}
