package dev.juliofonseca.springboot.mongodb.resource;

import dev.juliofonseca.springboot.mongodb.entity.User;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        User julio = new User("123", "Julio Cesar", "juliocsrmf@gmail.com");
        User alex = new User("1235", "Alex Brown", "alexbrown@gmail.com");

        List<User> users = new ArrayList<>(Arrays.asList(julio, alex));
        return ResponseEntity.ok().body(users);
    }
}
