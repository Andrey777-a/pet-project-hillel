package com.example.springhillel.api.service.crudservice;

import com.example.springhillel.api.service.AbstractServiceImpl;
import com.example.springhillel.model.dto.RoleDTO;
import com.example.springhillel.model.entity.Role;
import com.example.springhillel.repository.jpacrudrepozitory.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends AbstractServiceImpl<Role, RoleDTO, RoleRepository> {

}
