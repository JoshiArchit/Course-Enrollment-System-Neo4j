/**
 * Course.java
 * Author : Archit Joshi
 * Description : Model that describes the Course Node in the graph
 */

package io.github.architjoshi2904.springbootneo4j.models;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

// @Node annotation is used to mark the class as a Node in the graph
@Node
public class Course {
    // @Id annotation is used to mark the field as the primary key and
    // @GeneratedValue is used to auto-generate the value, so we
    // dont need a setter for this field
    @Id @GeneratedValue
    private Long id;

    private String identifier;
    private String title;
    private String teacher;

//    // Doesnt allow lazy loading, thus relationship is loaded everytime we query for a Course
//    @Relationship(type = "BELONGS_TO", direction = Relationship.Direction.INCOMING)
//    private List<Lesson> lesson = new ArrayList<>();

    // Requirement for Spring Neo4j - Create a default constructor
    public Course() {
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier( String identifier ) {
        this.identifier = identifier;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle( String title ) {
        this.title = title;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher( String teacher ) {
        this.teacher = teacher;
    }

//    // Binding for @Relationship. Doesnt allow lazy loading, thus relationship
//    // is loaded everytime we query for a Course
//    public List< Lesson > getLesson() {
//        return lesson;
//    }
}
