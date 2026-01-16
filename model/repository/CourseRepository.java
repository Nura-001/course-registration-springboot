package com.example.courseapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.courseapp.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
