package dev.juliofonseca.springboot.mongodb.service;

import dev.juliofonseca.springboot.mongodb.entity.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();
}
