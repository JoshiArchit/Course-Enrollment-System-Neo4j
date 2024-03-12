package io.github.architjoshi2904.springbootneo4j.services;

import io.github.architjoshi2904.springbootneo4j.models.Course;
import io.github.architjoshi2904.springbootneo4j.repositories.CourseRepository;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
  * CourseService.java
  * Author : Archit Joshi
  * Version :
  * Revisions :
  */

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService( CourseRepository courseRepository ) {
        this.courseRepository = courseRepository;
    }

    public List< Course > getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseByIdentifier( String identifier ) {
        return courseRepository.findCourseByIdentifier( identifier ).
                orElseThrow( ()-> new ResponseStatusException(
                        HttpStatusCode.valueOf( 404 )) );
    }
}

