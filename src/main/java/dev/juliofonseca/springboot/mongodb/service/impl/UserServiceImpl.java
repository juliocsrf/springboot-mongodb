package dev.juliofonseca.springboot.mongodb.service.impl;

import dev.juliofonseca.springboot.mongodb.entity.User;
import dev.juliofonseca.springboot.mongodb.repository.UserRepository;
import dev.juliofonseca.springboot.mongodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
