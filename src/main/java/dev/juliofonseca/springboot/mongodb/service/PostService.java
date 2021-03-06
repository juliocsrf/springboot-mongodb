package dev.juliofonseca.springboot.mongodb.service;

import dev.juliofonseca.springboot.mongodb.entity.Post;

import java.util.Date;
import java.util.List;

public interface PostService {

    Post findById(String id);
    List<Post> findByTitle(String text);
    List<Post> fullSearch(String text, Date minDate, Date maxDate);

}
