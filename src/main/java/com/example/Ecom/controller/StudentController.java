package com.example.Ecom.controller;

import com.example.Ecom.dto.AssignStudentCourseDto;
import com.example.Ecom.dto.CreateStudentDto;
import com.example.Ecom.model.Course;
import com.example.Ecom.model.Student;
import com.example.Ecom.repository.ICourseRepository;
import com.example.Ecom.repository.IStudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("student")
public class StudentController {
    private IStudentRepository studentRepository;
    private ICourseRepository courseRepository;
    public StudentController(IStudentRepository studentRepository , ICourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @PostMapping
    public void  CreateStudent(@RequestBody CreateStudentDto createStudentDto){
        Student student = new Student();
        student.name = createStudentDto.name;

        studentRepository.save(student);
    }

    @GetMapping
    public List<Student> GetAllStudents(){
        return studentRepository.findAll();
    }

    @PostMapping("assigncoursetostudent")
    public ResponseEntity<String> AssignCourseToStudent(@RequestBody AssignStudentCourseDto dto){
        Optional<Student> student= studentRepository.findById(dto.studentId);
        if(student.isEmpty())
        {
            return ResponseEntity.badRequest().body("Student not found");
        }

        Optional<Course> course=courseRepository.findById(dto.courseId);

        if(course.isEmpty())
        {
            return ResponseEntity.badRequest().body("Course not found");
        }

        student.get().courses.add(course.get());
        studentRepository.save(student.get());
        return ResponseEntity.ok().body("Course has been assigned");
    }
}
