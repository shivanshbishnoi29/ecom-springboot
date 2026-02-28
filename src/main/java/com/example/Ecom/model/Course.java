package com.example.Ecom.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue
    public  int id;

    public  String name;

    @ManyToMany
    @JoinTable(
            name = "studentcourse",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name="student_id")

    )
    @JsonIgnoreProperties("courses")
    public List<Student> students;
}
