package com.example.demo.service;

import com.example.demo.entity.File;
import com.example.demo.entity.User;
import com.example.demo.model.FileResponse;
import com.example.demo.model.UserResponse;
import com.example.demo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserService {

    @Autowired
    UserRepository repository;

    public String userInformationToString(User user) {
        return "Login: " + user.getLogin() + "\n" +
                "role: " + user.getRole();
    }

    public List<UserResponse> getJsonUserList(){
        return repository.findAll().stream()
                .map(u -> new UserResponse(u.getLogin(),u.getRole()))
                .collect(Collectors.toList());
    }

    public void getUserList () {
        List<User> list = repository.findAll();
        for (int i = 0; i < list.size(); i++){
            userInformationToString(list.get(i));
            System.out.println(userInformationToString(list.get(i)));
        }
    }


}
