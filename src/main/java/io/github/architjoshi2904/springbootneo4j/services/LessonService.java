package io.github.architjoshi2904.springbootneo4j.services;

import io.github.architjoshi2904.springbootneo4j.models.Lesson;
import io.github.architjoshi2904.springbootneo4j.repositories.LessonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
  * LessonService.java
  * Author : Archit Joshi
  * Version :
  * Revisions :
  */

@Service
public class LessonService {

    private final LessonRepository lessonRepository;

    public LessonService( LessonRepository lessonRepository ) {
        this.lessonRepository = lessonRepository;
    }

    public List< Lesson > getAllLessonsByCourseIdentifier( String identifier) {
        return lessonRepository.findLessonsByCourseIdentifier( identifier );
    }
}
