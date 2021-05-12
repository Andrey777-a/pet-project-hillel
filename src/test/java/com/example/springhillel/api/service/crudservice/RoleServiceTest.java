package com.example.springhillel.api.service.crudservice;

import com.example.springhillel.model.dto.RoleDTO;
import com.example.springhillel.model.entity.Role;
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
class RoleServiceTest {

    private static Role role;

    private static RoleDTO roleDTO;

    @Mock
    private RoleService roleService;

    @BeforeAll
    public static void beforeAll(){

        role = new Role("TEST_ADMIN");
        roleDTO = new RoleDTO("TEST_ADMIN");

    }

    @Test
    public void testCreateRole(){
        roleService.save(roleDTO);

        ArgumentCaptor<RoleDTO> requestCaptor = ArgumentCaptor.forClass(RoleDTO.class);

        Mockito.verify(roleService).save(requestCaptor.capture());

        assertFalse(requestCaptor.getAllValues().isEmpty());
        RoleDTO capturedArgument = requestCaptor.getValue();
        assertEquals("TEST_ADMIN", capturedArgument.getName());
    }

    @Test
    public void testGetAllRole(){

        List<Role> roleList = new ArrayList<>();
        roleList.add(role);

        Mockito.when(roleService.getAll()).thenReturn(roleList);

        assertEquals("TEST_ADMIN", roleService.getAll().get(0).getName());

        Mockito.verify(roleService).getAll();
    }


    @Test
    public void testFindByIdRole(){

        Optional<Role> roleOptional = Optional.of(role);

        Mockito.when(roleService.findById(1L)).thenReturn(roleOptional);

        assertEquals("TEST_ADMIN", roleService.findById(1).get().getName());

        Mockito.verify(roleService).findById(1L);
    }

    @Test
    public void testDeleteRole(){

        roleService.deleteById(1);

        Mockito.verify(roleService).deleteById(1);

    }

    @Test
    public void testUpdateRole(){

        Mockito.doNothing().when(roleService).update(role);
    }

}