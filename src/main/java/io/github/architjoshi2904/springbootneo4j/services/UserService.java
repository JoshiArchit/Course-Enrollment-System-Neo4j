package io.github.architjoshi2904.springbootneo4j.services;

import io.github.architjoshi2904.springbootneo4j.models.User;
import io.github.architjoshi2904.springbootneo4j.repositories.UserRepository;
import io.github.architjoshi2904.springbootneo4j.requests.CreateUserRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
  * UserService.java
  * Author : Archit Joshi
  * Version :
  * Revisions :
  */
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Function to return the user
    public User createUser( CreateUserRequest request) {
        User user = new User();

        user.setName( request.getName() );
        // TODO: Make sure username exists
        user.setUsername( request.getUsername() );
        user.setRoles( request.getRoles() );
        user.setPassword( passwordEncoder.encode( request.getPassword() ) );

        userRepository.save( user );
        return user;
    }

}
