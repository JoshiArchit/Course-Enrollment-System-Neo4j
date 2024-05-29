package io.github.architjoshi2904.springbootneo4j.repositories;

import io.github.architjoshi2904.springbootneo4j.models.Course;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends Neo4jRepository< Course, Long> {
    // Returns a course by identifier
    Optional<Course> findCourseByIdentifier( String identifier);

    @Query("MATCH (:User {username: $username})-[:ENROLLED_IN]->(courses:Course)" +
            "RETURN courses;")
    List<Course> findAllEnrolledCoursesByUserName(String username);
}
