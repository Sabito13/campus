package com.campusVirtual.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

import java.util.Optional;

import com.campusVirtual.model.Userdata;
import com.campusVirtual.repository.UserDataRepository;
import com.campusVirtual.service.implementation.UserDataService;

public class UserDataServiceTest {

    @Mock
    private UserDataRepository userDataRepositoryTest;

    @InjectMocks
    private UserDataService userDataServiceTest;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);

        
    }
    
    @Test
    void getUserById(){
when(userDataRepositoryTest.findById("ded13"))
.thenReturn(Optional.of(new Userdata(
    "ded13",
    "password",
  "jamila",
  "daz",
  "jamila@gmail.com","ROLE_ADMIN"
)));
        
        assertNotNull(userDataServiceTest.getUserById("ded13"));
    }
}
