package com.campusVirtual.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

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

    private Userdata userToTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        this.userToTest = new Userdata("ded13", "password", "jamila",
                "daz", "jamila@gmail.com", "ROLE_ADMIN");
    }

    @Test
    void getUserById(){
        
        when(userDataRepositoryTest.findById("ded13"))
        .thenReturn(Optional.of(this.userToTest));
        
        assertNotNull(userDataServiceTest.getUserById("ded13"));
        assertSame("jamila", userDataServiceTest.getUserById("ded13").getName());
    }

    

}
