package com.campusVirtual.security.userPasswordFilter;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.campusVirtual.model.AuthCredentials;
//import com.campusVirtual.repository.AuthCredentialsRepository;

@Service
public class UserDetailServiceImplementacion implements UserDetailsService{

    @Autowired
    //private AuthCredentialsRepository authCredentialsRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException { 
        Long id = (long) 1; 
        //AuthCredentials  UserAuthNull = this.authCredentialsRepository.findById(id).get();
        AuthCredentials  UserAuth = new AuthCredentials(id, "juan","a");
        return new UserDetailsImplementacion(UserAuth);
    }
    
}
