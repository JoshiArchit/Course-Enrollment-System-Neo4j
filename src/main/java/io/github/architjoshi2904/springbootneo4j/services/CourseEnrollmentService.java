package io.github.architjoshi2904.springbootneo4j.services;

import io.github.architjoshi2904.springbootneo4j.models.Course;
import io.github.architjoshi2904.springbootneo4j.queryresults.CourseEnrollmentQueryResult;
import io.github.architjoshi2904.springbootneo4j.repositories.CourseRepository;
import io.github.architjoshi2904.springbootneo4j.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
  * CourseEnrollmentService.java
  * Author : Archit Joshi
  * Version :
  * Revisions :
  */

@Service
public class CourseEnrollmentService {
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    public CourseEnrollmentService( CourseRepository courseRepository, UserRepository userRepository ) {
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
    }

    // Check given usernames enrollment status for course identifier
    public boolean getEnrollmentStatus(String username, String identifier) {
        return userRepository.findEnrollmentStatus(username, identifier);
    }

    // Create relationship
    public CourseEnrollmentQueryResult enrollIn(String username, String identifier) {
        return userRepository.createEnrollmentRelationship( username, identifier );
    }

    public List< Course > getAllEnrollmentCoursesByUsername( String username) {
        return courseRepository.findAllEnrolledCoursesByUserName( username );
    }
}
