package com.example.springhillel.api.service.crudservice;

import com.example.springhillel.model.datail.CustomUserDetails;
import com.example.springhillel.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public CustomUserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userService.findByUserLogin(s);

        return CustomUserDetails.fromUserEntityToUserDetails(user);
    }
}
