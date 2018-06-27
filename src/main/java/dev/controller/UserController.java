package dev.controller;

import dev.entity.User;
import dev.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/rest")
@CrossOrigin
public class UserController {

    @Autowired
    UserRepository userRepository;

    // returns the current authneticated user
    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

    // returns the user selected by email
    @RequestMapping(value = "/getUser/{userEmail}", method = RequestMethod.GET)
    @Secured({})
    public ResponseEntity<User> getUser(@PathVariable String userEmail){
        User user = userRepository.findByEmail(userEmail);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // returns the user role of the user selected by email
    @RequestMapping(value = "/getUserRole/{userEmail}", method = RequestMethod.GET)
    @Secured({})
    public ResponseEntity<User.ROLES> getUserRole(@PathVariable String userEmail){
        User user = userRepository.findByEmail(userEmail);
        if (user != null) {
            return ResponseEntity.ok(user.getRoles());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
