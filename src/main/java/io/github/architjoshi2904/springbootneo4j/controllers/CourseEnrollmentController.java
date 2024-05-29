package io.github.architjoshi2904.springbootneo4j.controllers;

import io.github.architjoshi2904.springbootneo4j.objects.CourseEnrollmentDTO;
import io.github.architjoshi2904.springbootneo4j.services.CourseEnrollmentService;
import io.github.architjoshi2904.springbootneo4j.services.LessonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
  * CourseEnrollmentController.java
  * Author : Archit Joshi
  * Version :
  * Revisions :
  */

@RestController
@RequestMapping("api/v1/enrolments")
public class CourseEnrollmentController {
    private final CourseEnrollmentService courseEnrollmentService;
    private final LessonService lessonService;

    public CourseEnrollmentController( CourseEnrollmentService courseEnrollmentService, LessonService lessonService ) {
        this.courseEnrollmentService = courseEnrollmentService;
        this.lessonService = lessonService;
    }

    // Endpoints
    // 1. Allow user to enroll in course
    public ResponseEntity< CourseEnrollmentDTO >
}
