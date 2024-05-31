package io.github.architjoshi2904.springbootneo4j.config;

import io.github.architjoshi2904.springbootneo4j.services.NeoUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

/**
  * SecurityConfig.java
  * Author : Archit Joshi
  * Version :
  * Revisions :
  */

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final NeoUserDetailsService neoUserDetailsService;

    public SecurityConfig( NeoUserDetailsService neoUserDetailsService ) {
        this.neoUserDetailsService = neoUserDetailsService;
    }

    // Create a bean for the password encoder
    // SecurityFIlterChain is used to configure the security for the application
    // It logs every request and response to the server
    @Bean
    SecurityFilterChain securityFilterChain( HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .sessionManagement(session -> session.sessionCreationPolicy( SessionCreationPolicy.STATELESS ))
                .csrf( AbstractHttpConfigurer::disable)
                .cors( Customizer.withDefaults() )
                .authorizeHttpRequests(auth -> auth
                        // Endpoints that require authentication
                        .requestMatchers(
                                "/api/v1/auth/me",
                                "/api/v1/enrollments/**"
                        ).authenticated()
                        // Permit all other requests
                        .anyRequest().permitAll()
                )
                // Use the neoUserDetailsService to authenticate the user
                .userDetailsService( neoUserDetailsService )
                .httpBasic( Customizer.withDefaults() )
                .build();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource () {
        CorsConfiguration corsConfiguration = new CorsConfiguration();

        // Allow the origins for the react app to access the server
        // @TODO: make sure that the origin list comes from an env file
        corsConfiguration.setAllowedOrigins( Arrays.asList("http://localhost:3000", "http://127.0.0.1:3000") );
        corsConfiguration.setAllowedMethods( Arrays.asList("GET", "POST", " PATCH", "PUT", "DELETE", "OPTIONS", "HEAD") );
        corsConfiguration.setAllowCredentials( true );
        corsConfiguration.setAllowedHeaders( Arrays.asList("Authorization", "Request-Type", "Content-Type") );
        corsConfiguration.setExposedHeaders( Arrays.asList("X-Get-Header"));
        corsConfiguration.setMaxAge( 3600L );

        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        // Apply the cors configuration to all the endpoints
        urlBasedCorsConfigurationSource.registerCorsConfiguration( "/**", corsConfiguration );

        return urlBasedCorsConfigurationSource;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
