package com.campusVirtual.security.userPasswordFilter;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.campusVirtual.model.Alumno;
import com.campusVirtual.repository.AlumnoRepository;

@Service
public class UserDetailServiceImplementacion implements UserDetailsService{

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException { 
        Long id = (long) 1; 
        Alumno  miAlumno = this.alumnoRepository.findById(id).get();

        return new UserDetailsImplementacion(miAlumno);
    }
    
}
