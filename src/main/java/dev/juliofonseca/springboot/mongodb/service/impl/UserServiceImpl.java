package dev.juliofonseca.springboot.mongodb.service.impl;

import dev.juliofonseca.springboot.mongodb.entity.User;
import dev.juliofonseca.springboot.mongodb.repository.UserRepository;
import dev.juliofonseca.springboot.mongodb.service.UserService;
import dev.juliofonseca.springboot.mongodb.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()) {
            throw new ObjectNotFoundException("Usuário não encontrado. ID: " + id);
        }

        return user.get();
    }

    public User insert(User user) {
        return userRepository.insert(user);
    }

    public void deleteById(String id) {
        User user = this.findById(id);
        userRepository.delete(user);
    }

    public User update(User user) {
        User newUser = this.findById(user.getId());
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        return userRepository.save(newUser);
    }
}
