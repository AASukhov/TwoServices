package com.example.demo.controller;

import com.example.demo.model.FileResponse;
import com.example.demo.model.UserResponse;
import com.example.demo.service.FileService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/list")
    public List<UserResponse> getListAllFiles(){
        return userService.getJsonUserList();
    }

}
