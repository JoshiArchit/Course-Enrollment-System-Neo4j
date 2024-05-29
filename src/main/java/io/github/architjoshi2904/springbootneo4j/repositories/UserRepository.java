package io.github.architjoshi2904.springbootneo4j.repositories;

import io.github.architjoshi2904.springbootneo4j.models.User;
import io.github.architjoshi2904.springbootneo4j.queryresults.CourseEnrollmentQueryResult;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.Optional;

public interface UserRepository extends Neo4jRepository< User, Long > {
    Optional<User> findUserByUsername( String username );

    @Query("Match (user:User), (course:Course) " +
            "WHERE user.username = $username " +
            "AND course.identifier = $identifier" +
            "RETURN EXISTS((user)-[:ENROLLED_IN]->(course))")
    Boolean findEnrollmentStatus(String username, String identifier);

    @Query("Match (user:User), (course:Course) " +
            "WHERE user.username = $username " +
            "AND course.identifier = $identifier" +
            "CREATE (user)-[:ENROLLED_IN]->(course)" +
            "RETURN user,course")
    CourseEnrollmentQueryResult createEnrollmentRelationship(String username, String identifier);
}
