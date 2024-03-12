package io.github.architjoshi2904.springbootneo4j.repositories;

import io.github.architjoshi2904.springbootneo4j.models.Course;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Optional;

public interface CourseRepository extends Neo4jRepository< Course, Long> {
    // Returns a course by identifier
    Optional<Course> findCourseByIdentifier( String identifier);
}
