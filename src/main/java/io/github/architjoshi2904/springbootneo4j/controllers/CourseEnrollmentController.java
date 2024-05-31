package io.github.architjoshi2904.springbootneo4j.controllers;

import io.github.architjoshi2904.springbootneo4j.models.Course;
import io.github.architjoshi2904.springbootneo4j.objects.CourseDTO;
import io.github.architjoshi2904.springbootneo4j.objects.CourseEnrollmentDTO;
import io.github.architjoshi2904.springbootneo4j.queryresults.CourseEnrollmentQueryResult;
import io.github.architjoshi2904.springbootneo4j.requests.CourseEnrollmentRequest;
import io.github.architjoshi2904.springbootneo4j.services.CourseEnrollmentService;
import io.github.architjoshi2904.springbootneo4j.services.LessonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

/**
  * CourseEnrollmentController.java
  * Author : Archit Joshi
  * Version :
  * Revisions :
  */

@RestController
@RequestMapping("/api/v1/enrollments")
public class CourseEnrollmentController {
    private final CourseEnrollmentService courseEnrollmentService;
    private final LessonService lessonService;

    public CourseEnrollmentController( CourseEnrollmentService courseEnrollmentService, LessonService lessonService ) {
        this.courseEnrollmentService = courseEnrollmentService;
        this.lessonService = lessonService;
    }

    public ResponseEntity< List< CourseDTO > > enrollments(Principal principal){
        List< Course > courses = courseEnrollmentService.getAllEnrollmentCoursesByUsername( principal.getName() );

        List<CourseDTO> responseCourses = courses.stream().map(
                (course) -> {
                    CourseDTO responseCourse = new CourseDTO( course.getIdentifier(), course.getTitle(), course.getTeacher() );
                    responseCourse.setLessons( lessonService.getAllLessonsByCourseIdentifier( course.getIdentifier() ) );
                    responseCourse.setEnrolled( true );
                    return responseCourse;
                }
        ).collect( Collectors.toList());

        return new ResponseEntity<>( responseCourses, HttpStatus.OK );
    }

    // Endpoints
    // 1. Allow user to enroll in course
    @PostMapping("/")
    public ResponseEntity< CourseEnrollmentDTO > enrollIn( @RequestBody CourseEnrollmentRequest request, Principal principal ) {
        CourseEnrollmentQueryResult enrollmentQueryResult = courseEnrollmentService.enrollIn( principal.getName(), request.getCourseIdentifier() );
        CourseEnrollmentDTO responseEnrollment = new CourseEnrollmentDTO(
                enrollmentQueryResult.getUser().getUsername(),
                enrollmentQueryResult.getUser().getName(),
                enrollmentQueryResult.getCourse());
        return new ResponseEntity<>( responseEnrollment, HttpStatus.OK );
    }
}
