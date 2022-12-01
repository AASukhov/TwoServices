package com.example.demo.jwt;

import com.example.demo.jwt.JwtTokenFilter;
import com.example.demo.jwt.JwtTokenProvider;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JwtConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private JwtTokenProvider provider;

    public JwtConfigurer (JwtTokenProvider provider) {
        this.provider = provider;
    }

    @Override
    public void configure(HttpSecurity security) {
        JwtTokenFilter filter = new JwtTokenFilter(provider);
        security.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
    }
}
