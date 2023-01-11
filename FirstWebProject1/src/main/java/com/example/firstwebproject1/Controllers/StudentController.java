package com.example.firstwebproject1.Controllers;

import com.example.firstwebproject1.Services.StudentService;
import com.example.firstwebproject1.entity.Student;
import com.example.firstwebproject1.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // handler Method to handle list student and return mode and view
    @GetMapping("/students")
    public String listStudent(Model model)
    {
        model.addAttribute("students",studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model)
    {
        //create student object to hold student form data
        Student student=new Student();
        model.addAttribute("student",student);
        return "create_student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student)
    {
         studentService.saveStudent(student);
         return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Integer id,Model model)
    {
        model.addAttribute("student",studentService.getStudentById(id));
        return "edit_student";
    }

    @PostMapping("/students/{id}")
    public String UpdateStudent(@PathVariable Integer id, @ModelAttribute("student") Student student,Model model)
    {
        //get Student from database by id
        Student existingStudent=studentService.getStudentById(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        //save update student object

        studentService.updateStudent(existingStudent);
        return "redirect:/students";
    }

    //handler method to handle delete student request
    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Integer id)
    {
        studentService.deleteStudentbyId(id);
        return "redirect:/students";
    }
}
