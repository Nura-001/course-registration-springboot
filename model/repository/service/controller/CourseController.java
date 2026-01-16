package com.example.courseapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.courseapp.model.Course;
import com.example.courseapp.service.CourseService;

@Controller
public class CourseController {

    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @GetMapping("/courses")
    public String viewCourses(Model model) {
        model.addAttribute("courses", service.getAllCourses());
        return "course-list";
    }

    @PostMapping("/courses")
    public String addCourse(Course course) {
        service.saveCourse(course);
        return "redirect:/courses";
    }

    @GetMapping("/courses/delete/{id}")
    public String deleteCourse(@PathVariable Long id) {
        service.deleteCourse(id);
        return "redirect:/courses";
    }

    @GetMapping("/courses/edit/{id}")
    public String editCourse(@PathVariable Long id, Model model) {
        model.addAttribute("course", service.getCourse(id));
        return "edit-course";
    }

    @PostMapping("/courses/update")
    public String updateCourse(Course course) {
        service.saveCourse(course);
        return "redirect:/courses";
    }
}
