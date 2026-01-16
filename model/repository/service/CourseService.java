package com.example.courseapp.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.example.courseapp.model.Course;
import com.example.courseapp.repository.CourseRepository;

@Service
public class CourseService {

    private final CourseRepository repo;

    public CourseService(CourseRepository repo) {
        this.repo = repo;
    }

    public List<Course> getAllCourses() {
        return repo.findAll();
    }

    public void saveCourse(Course course) {
        repo.save(course);
    }

    public void deleteCourse(Long id) {
        repo.deleteById(id);
    }

    public Course getCourse(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
    }
}
