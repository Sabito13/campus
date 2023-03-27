package com.campusVirtual.security.userPasswordFilter;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.campusVirtual.model.Userdata;
import com.campusVirtual.service.IUserDataService;
import com.campusVirtual.dto.UserRegisterDto;
import com.campusVirtual.exception.InvalidInputFieldException;
import com.campusVirtual.exception.UserAlreadyExistsException;

@Service
public class UserDetailServiceImplementacion implements UserDetailsService{

    @Autowired
    private IUserDataService userDataService;

    @Autowired
	PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException { 
        //Userdata  UserAuth = this.authCredentialsRepository.findById(userName).orElseThrow(()-> new ObjectNotFoundException("User",userName));
        //AuthCredentials  UserAuth = new AuthCredentials(dni, "juan","a");
        Userdata  UserAuth = userDataService.getUserById(userName);
        return new UserDetailsImplementacion(UserAuth);
    }


    public String saveUser(UserRegisterDto userRegister){
        
        
        


        String username = userRegister.getUsername();
		String password = userRegister.getPassword();

        
        
        

		if (password == null || username == null)
			throw new InvalidInputFieldException("Username or Password was not entered");
        
        if (username.isBlank() || password.isBlank())
			throw new InvalidInputFieldException("Username or Password is blank");
        
        if (this.userDataService.existsUserById(username))
            throw new UserAlreadyExistsException("Already exists user with that username");
        
        if (password == null || username == null)
			throw new InvalidInputFieldException("Username or Password was not entered");
        
        if (username.isBlank() || password.isBlank())
			throw new InvalidInputFieldException("Username or Password is blank");

		
	
            userRegister.setPassword(passwordEncoder.encode(userRegister.getPassword()));
		
		this.userDataService.saveUser(new Userdata(
            userRegister.getUsername(),
            userRegister.getPassword(),
            userRegister.getName(),
            userRegister.getLastName(),
            userRegister.getMail()));
		
		
		return  "Your registration was successful!";
		
		}
	
    
}
