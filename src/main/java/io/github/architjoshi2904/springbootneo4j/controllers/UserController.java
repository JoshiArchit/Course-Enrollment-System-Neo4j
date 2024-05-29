package io.github.architjoshi2904.springbootneo4j.controllers;

import io.github.architjoshi2904.springbootneo4j.models.User;
import io.github.architjoshi2904.springbootneo4j.objects.UserDTO;
import io.github.architjoshi2904.springbootneo4j.requests.CreateUserRequest;
import io.github.architjoshi2904.springbootneo4j.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
  * UserController.java
  * Author : Archit Joshi
  * Version :
  * Revisions :
  */
 @RestController
 @RequestMapping("/api/v1/auth")
public class UserController {

     private final UserService userService;

     public UserController(UserService userService) {
         this.userService = userService;
     }

     @GetMapping("/me")
     public String loggedInUser ( Principal principal) {
         return principal.getName();
     }

     @PostMapping("/register")
     public ResponseEntity< UserDTO > signUp( @RequestBody CreateUserRequest request) {
         User user = userService.createUser( request );
         UserDTO responseUser  = new UserDTO(user.getName(), user.getUsername(), user.getRoles());

         return new ResponseEntity<>( responseUser, HttpStatus.CREATED );
     }
}

