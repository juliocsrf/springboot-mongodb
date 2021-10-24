package dev.juliofonseca.springboot.mongodb.service;

import dev.juliofonseca.springboot.mongodb.entity.Post;

public interface PostService {

    Post findById(String id);

}
