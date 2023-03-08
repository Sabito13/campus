package com.campusVirtual.security.userPasswordFilter;

import java.util.Collections;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.campusVirtual.model.Alumno;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public class UserDetailsImplementacion implements UserDetails {

    private final Alumno alumno;



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       return Collections.emptyList();
    }

  

    @Override
    public String getPassword() {
        return "1";
    }

    @Override
    public String getUsername() {
       return this.alumno.getNombre();
    }

    @Override
    public boolean isAccountNonExpired() {
       return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Long getId(){
        return this.alumno.getId();
    }
    
}
