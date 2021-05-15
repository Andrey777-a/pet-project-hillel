package com.example.springhillel.api.service.crudservice;

import com.example.springhillel.model.dto.UserDTO;
import com.example.springhillel.model.entity.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class UserServiceTest {

    private static User user;
    private static UserDTO userDTO;

    @Mock
    private UserService userService;


    @BeforeAll
    public static void beforeAll(){
        user = new User("Test_name", "Test_last_name", "Test_password", "Test_email");
        userDTO = new UserDTO("Test_name", "Test_last_name", "Test_password", "Test_email", 1);

    }

    @Test
    public void testCreateUser(){
        userService.save(userDTO);

        ArgumentCaptor<UserDTO> requestCaptor = ArgumentCaptor.forClass(UserDTO.class);

        Mockito.verify(userService).save(requestCaptor.capture());

        assertFalse(requestCaptor.getAllValues().isEmpty());
        UserDTO capturedArgument = requestCaptor.getValue();
        assertEquals("Test_name", capturedArgument.getFirstName());

    }

    @Test
    public void testGetAllUser(){

        List<User> userList = new ArrayList<>();
        userList.add(user);

        Mockito.when(userService.getAll()).thenReturn(userList);

        assertEquals("Test_name", userService.getAll().get(0).getFirstName());

    }

    @Test
    public void testFindByIdUser(){

        Optional<User> userOptional = Optional.of(user);

        Mockito.when(userService.findById(1)).thenReturn(userOptional);

        assertEquals("Test_name", userService.findById(1).get().getFirstName());

        Mockito.verify(userService).findById(1);

    }

    @Test
    public void testDeleteUser(){

        userService.deleteById(1);

        Mockito.verify(userService).deleteById(1);

    }

    @Test
    public void testUpdateUser(){

        userService.update(user);

        Mockito.verify(userService).update(user);

    }

}