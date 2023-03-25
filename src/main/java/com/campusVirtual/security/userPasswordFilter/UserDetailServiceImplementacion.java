package com.campusVirtual.security.userPasswordFilter;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.campusVirtual.model.Userdata;
import com.campusVirtual.repository.UserDataRepository;
import com.campusVirtual.dto.UserRegisterDto;
import com.campusVirtual.exception.UserNotFoundException;

@Service
public class UserDetailServiceImplementacion implements UserDetailsService{

    @Autowired
    private UserDataRepository authCredentialsRepository;

    @Autowired
	PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException { 
        Userdata  UserAuth = this.authCredentialsRepository.findById(userName).orElseThrow(()-> new UserNotFoundException(userName));
        //AuthCredentials  UserAuth = new AuthCredentials(dni, "juan","a");
        return new UserDetailsImplementacion(UserAuth);
    }


    public String saveUser(UserRegisterDto userRegister){
        
        String username = userRegister.getUsername();
		String password = userRegister.getPassword();

		
		 if (password == null)
			throw new RuntimeException("the password was not entered");
        else if (username == null)
			throw new RuntimeException("the username was not entered");
		
        
        if (username.isBlank() || password.isBlank())
			throw new RuntimeException("username or password is blank");

        if (this.authCredentialsRepository.existsById(username))
			throw new RuntimeException("Already exists user with that username");
		
	
            userRegister.setPassword(passwordEncoder.encode(userRegister.getPassword()));
		
		this.authCredentialsRepository.save(new Userdata(
            userRegister.getUsername(),
            userRegister.getPassword(),
            userRegister.getNombre(),
            userRegister.getApellido(),
            userRegister.getMail()));
		
		
		return  " your registration was successful!";
		
		}
	
    
}
