package com.example.firstwebproject1.Services.StudentServiceImpl;

import com.example.firstwebproject1.Services.StudentService;
import com.example.firstwebproject1.entity.Student;
import com.example.firstwebproject1.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public  Student saveStudent(Student student)
    {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Integer id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudentbyId(Integer id) {
        studentRepository.deleteById(id);
    }

}
