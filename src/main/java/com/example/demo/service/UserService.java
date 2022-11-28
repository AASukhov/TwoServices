package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService {

    private final UserRepository repository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository repository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.repository = repository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public List<User> findAll() {
        List<User> result = repository.findAll();
        if (result.isEmpty()) {
            log.info("In getAll(): the list of Users is empty");
            return null;
        } else {
            log.info("In getAll(): the list of Users contains {} users",result.size());
            return result;
        }
    }

    public User register (User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        log.info("In register() - new user {} successfully registered",user.getUsername());
        return repository.save(user);
    }

    public User findById(Long id) {
        User result = repository.findById(id);
        if (result == null) {
            log.warn("In findById() - no user with such Id " + id);
            return null;
        } else {
            log.info("In findById: User with id {} successfully found ", id);
            return result;
        }
    }

    public User findByUsername(String username) {
        User result = repository.findByUsername(username);
        if (result == null) {
            log.warn("In findByLogin - no user with such Login");
            return null;
        } else
            return result;
    }

    public void deleteById (Long id) {
        repository.delete(findById(id));
        log.info("In delete(): User with id {} was deleted",id);
    }

//    public List<UserResponse> getJsonUserList(){
//        return repository.findAll().stream()
//                .map(u -> new UserResponse(u.getUsername(),u.getRole()))
//                .collect(Collectors.toList());
//    }

//    public void getUserList () {
//        List<User> list = repository.findAll();
//        for (int i = 0; i < list.size(); i++){
//            userInformationToString(list.get(i));
//            System.out.println(userInformationToString(list.get(i)));
//        }
//    }

//    public String userInformationToString(User user) {
//        return "Login: " + user.getUsername() + "\n" +
//                "role: " + user.getRole();
//    }
}
