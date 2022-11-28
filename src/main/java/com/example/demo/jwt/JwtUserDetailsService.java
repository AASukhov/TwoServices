package com.example.demo.jwt;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JwtUserDetailsService implements UserDetailsService {

    private final UserService service;

    @Autowired
    public JwtUserDetailsService (UserService service) {
        this.service = service;
    }

    @Override
    public UserDetails loadUserByUsername (String username) {
        User user = service.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User with username " + username + " not found");
        }
        JwtUser jwtUser = JwtUserFactory.create(user);
        log.info("In loadUserByUsername() - user with username {} loaded successfully", username);
        return jwtUser;
    }
}
