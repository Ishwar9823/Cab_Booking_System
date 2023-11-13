package com.cabbooking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.cabbooking.dto.UserDTO;
import com.cabbooking.entity.User;
import com.cabbooking.exception.UserBookingException;
import com.cabbooking.repository.UserRepo;
import com.cabbooking.serviceimpl.IUserServiceImpl;

@SpringBootTest
public class IUserServiceImplTest {

    @Mock
    private UserRepo userRepo;

    @InjectMocks
    private IUserServiceImpl userService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRegisterUser() {
        User user = new User();
        user.setUserId(1);
        user.setRoles("USER");
        user.setAddress("Sample Address");
        user.setEmail("sample@example.com");
        user.setUserName("sampleUser");

        when(userRepo.save(any())).thenReturn(user);

        UserDTO result = userService.registerUser(user);

        assertEquals(user.getUserId(), result.getUserId());
        assertEquals(user.getRoles(), result.getRoles());
        assertEquals(user.getAddress(), result.getAddress());
        assertEquals(user.getEmail(), result.getEmail());
        assertEquals(user.getUserName(), result.getUserName());

        verify(userRepo, times(1)).save(any());
    }

    @Test
    public void testSignIn() throws UserBookingException {
        User user = new User();
        user.setUserId(1);
        user.setRoles("USER");
        user.setAddress("Sample Address");
        user.setEmail("sample@example.com");
        user.setUserName("sampleUser");
        user.setPassword("samplePassword");

        when(userRepo.findByUserName("sampleUser")).thenReturn(user);

        UserDTO result = userService.signIn("sampleUser", "samplePassword");

        assertEquals(user.getUserId(), result.getUserId());
        assertEquals(user.getRoles(), result.getRoles());
        assertEquals(user.getAddress(), result.getAddress());
        assertEquals(user.getEmail(), result.getEmail());
        assertEquals(user.getUserName(), result.getUserName());

        verify(userRepo, times(1)).save(user);
    }

    @Test
    public void testSignOut() throws UserBookingException {
        User user = new User();
        user.setUserId(1);
        user.setRoles("USER");
        user.setAddress("Sample Address");
        user.setEmail("sample@example.com");
        user.setUserName("sampleUser");

        when(userRepo.findById(1)).thenReturn(Optional.of(user));

        String result = userService.signOut(1);

        assertEquals("User Logged Out Successfully", result);

        verify(userRepo, times(0)).save(any());
    }

   
}

