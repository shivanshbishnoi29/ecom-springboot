package com.example.Ecom.controller;

import com.example.Ecom.dto.CreateCourseDto;
import com.example.Ecom.model.Course;
import com.example.Ecom.repository.ICourseRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("course")
public class CourseController {
    public ICourseRepository courseRepository;

    public CourseController(ICourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @PostMapping
    public void  CreateCourse(@RequestBody CreateCourseDto createCourseDto)
    {
        Course course = new Course();
        course.name = createCourseDto.name;

        courseRepository.save(course);
    }

    @GetMapping
    public List<Course> GetAllCourses()
    {
        return courseRepository.findAll();
    }
}
