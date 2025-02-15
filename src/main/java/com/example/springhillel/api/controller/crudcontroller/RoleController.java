package com.example.springhillel.api.controller.crudcontroller;

import com.example.springhillel.api.controller.AbstractControllerImpl;
import com.example.springhillel.api.service.crudservice.RoleService;
import com.example.springhillel.model.dto.RoleDTO;
import com.example.springhillel.model.entity.Role;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController extends AbstractControllerImpl<Role, RoleDTO, RoleService> {
}
