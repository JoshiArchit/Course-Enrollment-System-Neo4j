package io.github.architjoshi2904.springbootneo4j.requests;
/**
  * CourseEnrollmentRequest.java
  * Author : Archit Joshi
  * Version :
  * Revisions :
  */
 
public class CourseEnrollmentRequest {
    private String courseIdentifier;

    public CourseEnrollmentRequest( String courseIdentifier ) {
    }

    public String getCourseIdentifier() {
        return courseIdentifier;
    }

    public void setCourseIdentifier( String courseIdentifier ) {
        this.courseIdentifier = courseIdentifier;
    }
}
