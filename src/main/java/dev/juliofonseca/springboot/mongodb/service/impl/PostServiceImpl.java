package dev.juliofonseca.springboot.mongodb.service.impl;

import dev.juliofonseca.springboot.mongodb.entity.Post;
import dev.juliofonseca.springboot.mongodb.repository.PostRepository;
import dev.juliofonseca.springboot.mongodb.service.PostService;
import dev.juliofonseca.springboot.mongodb.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Post findById(String id) {
        Optional<Post> post = postRepository.findById(id);

        if(post.isEmpty()) {
            throw new ObjectNotFoundException("Post não encontrado. ID: " + id);
        }

        return post.get();
    }

    @Override
    public List<Post> findByTitle(String text) {
        return postRepository.searchTitle(text);

        // Outra forma de implementação:
        // return postRepository.findByTitleContainingIgnoreCase(text);
    }
}
