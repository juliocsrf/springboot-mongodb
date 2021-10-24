package dev.juliofonseca.springboot.mongodb.repository;

import dev.juliofonseca.springboot.mongodb.entity.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
