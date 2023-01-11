package com.example.firstwebproject1;

import com.example.firstwebproject1.entity.Student;
import com.example.firstwebproject1.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstWebProject1Application /*implements CommandLineRunner*/ {

    public static void main(String[] args) {
        SpringApplication.run(FirstWebProject1Application.class, args);
    }


   /* @Autowired
    private StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
        Student student=new Student();
        student.setFirstName("Majid");
        student.setLastName("Iqbal");
        student.setEmail("majidmayo1368@gmail.com");
        studentRepository.save(student);

        Student student2=new Student();
        student2.setFirstName("Sajid");
        student2.setLastName("Iqbal");
        student2.setEmail("sajidmayo4472@gmail.com");
        studentRepository.save(student2);
    }*/
}
