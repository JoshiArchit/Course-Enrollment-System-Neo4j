package io.github.architjoshi2904.springbootneo4j.queryresults;

import io.github.architjoshi2904.springbootneo4j.models.Course;
import io.github.architjoshi2904.springbootneo4j.models.User;

/**
  * CourseEnrollmentQueryResult.java
  * Author : Archit Joshi
  * Version :
  * Revisions :
  */
 
public class CourseEnrollmentQueryResult {
    private User user;
    private Course course;

    public CourseEnrollmentQueryResult(){}

    public void setUser(User user) {
        this.user = user;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public User getUser(){
        return user;
    }

    public Course getCourse(){
        return course;
    }
}
