package io.github.architjoshi2904.springbootneo4j.repositories;

import io.github.architjoshi2904.springbootneo4j.models.Lesson;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface LessonRepository extends Neo4jRepository< Lesson, Long> {
    // Identifier is not a lesson field, but a field in Course. Thus need to
    // use a custom query

    @Query("MATCH (:Course {identifier:$identifier})<-[:BELONGS_TO]-(lessons:Lesson) RETURN lessons")
    List<Lesson> findLessonsByCourseIdentifier( String identifier);
}
