package com.example.springhillel.api.service.crudservice.convert;

import com.example.springhillel.model.dto.RoleDTO;
import com.example.springhillel.model.entity.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleConvert implements AbstractConvert<Role, RoleDTO> {

    @Override
    public Role convertToEntity(RoleDTO roleDTO) {

        return new Role(roleDTO.getName());
    }

    @Override
    public RoleDTO covertToDTO(Role role) {
        return new RoleDTO(role.getName());
    }
}
