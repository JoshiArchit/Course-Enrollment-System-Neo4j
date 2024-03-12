package io.github.architjoshi2904.springbootneo4j.services;

import io.github.architjoshi2904.springbootneo4j.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
  * NeoUserDetailsService.java
  * Author : Archit Joshi
  * Version :
  * Revisions :
  */

@Service
public class NeoUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public NeoUserDetailsService( UserRepository userRepository ) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername( String username ) throws UsernameNotFoundException {
        // Return the user from the database
        return userRepository.
                findUserByUsername( username )
                .orElseThrow( () -> new UsernameNotFoundException( "Username not found " + username ) );
    }
}
