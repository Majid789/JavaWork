package com.example.firstwebproject1.Services;

import com.example.firstwebproject1.entity.Student;
import com.example.firstwebproject1.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();
    Student saveStudent(Student student);

    Student getStudentById(Integer id);

    Student updateStudent(Student student);

    void deleteStudentbyId(Integer id);
}
