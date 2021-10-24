package dev.juliofonseca.springboot.mongodb.dto;

import dev.juliofonseca.springboot.mongodb.entity.User;

import java.io.Serializable;

public class UserDTO implements Serializable {

    private String id;
    private String name;
    private String email;

    public UserDTO(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public static User convertToEntity(UserDTO userDTO){
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }
}
