package io.github.architjoshi2904.springbootneo4j.objects;

import io.github.architjoshi2904.springbootneo4j.models.Course;

/**
  * CourseEnrollmentDTO.java
  * Author : Archit Joshi
  * Version :
  * Revisions :
  */
 
public class CourseEnrollmentDTO {
    private String username;
    private String name;
    private Course course;

    public CourseEnrollmentDTO(String username, String name, Course course) {
        this.username = username;
        this.name = name;
        this.course = course;
    }



}
