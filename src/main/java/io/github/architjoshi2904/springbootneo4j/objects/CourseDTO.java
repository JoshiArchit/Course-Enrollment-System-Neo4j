package io.github.architjoshi2904.springbootneo4j.objects;

import io.github.architjoshi2904.springbootneo4j.models.Lesson;

import java.util.ArrayList;
import java.util.List;

/**
  * CourseDTO.java
  * Author : Archit Joshi
  * Version :
  * Revisions :
  */
 
public class CourseDTO {
    private String identifier;
    private String title;
    private String teacher;
    private List< Lesson > lessons = new ArrayList<>();
    public boolean isEnrolled;

    public CourseDTO( String identifier, String title, String teacher ) {
        this.identifier = identifier;
        this.title = title;
        this.teacher = teacher;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getTitle() {
        return title;
    }

    public String getTeacher() {
        return teacher;
    }

    public List< Lesson > getLessons() {
        return lessons;
    }

    public void setLessons( List< Lesson > lessons ) {
        this.lessons = lessons;
    }

    public boolean isEnrolled() {
        return isEnrolled;
    }

    public void setEnrolled( boolean enrolled ) {
        isEnrolled = enrolled;
    }
}
