package io.github.architjoshi2904.springbootneo4j.requests;
/**
  * CourseEnrollmentRequest.java
  * Author : Archit Joshi
  * Version :
  * Revisions :
  */
 
public class CourseEnrollmentRequest {
    private String identifier;

    public CourseEnrollmentRequest( String identifier ) {
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier( String identifier ) {
        this.identifier = identifier;
    }
}
