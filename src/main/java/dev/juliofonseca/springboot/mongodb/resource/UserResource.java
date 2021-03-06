package dev.juliofonseca.springboot.mongodb.resource;

import dev.juliofonseca.springboot.mongodb.dto.UserDTO;
import dev.juliofonseca.springboot.mongodb.entity.Post;
import dev.juliofonseca.springboot.mongodb.entity.User;
import dev.juliofonseca.springboot.mongodb.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> users = userService.findAll();
        List<UserDTO> userDTOList = users.stream().map(UserDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(userDTOList);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        User user = userService.findById(id);
        UserDTO userDTO = new UserDTO(user);
        return ResponseEntity.ok().body(userDTO);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody UserDTO userDTO) {
        User user = UserDTO.convertToEntity(userDTO);
        user = userService.insert(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable String id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody UserDTO userDTO) {
        userDTO.setId(id);
        userService.update(UserDTO.convertToEntity(userDTO));
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}/posts", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> getPosts(@PathVariable String id) {
        User user = userService.findById(id);
        return ResponseEntity.ok().body(user.getPosts());
    }

}
