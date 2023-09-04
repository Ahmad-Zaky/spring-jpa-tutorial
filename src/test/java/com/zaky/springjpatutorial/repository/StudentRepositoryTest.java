package com.zaky.springjpatutorial.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.zaky.springjpatutorial.entity.Student;
import com.zaky.springjpatutorial.entity.Guardian;


@SpringBootTest

/*
 * NOTE: This line, we comment it as we want to presist the data into db,
 * for testing the functionality of our Repository
 */
// @DataJpaTest
public class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
            .email("me4@email.com")
            .firstName("ahmed")
            .lastName("zaky")
            .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
            .name("fouad")
            .email("fouad2@email.com")
            .mobile("01111111111")
            .build();

        Student student = Student.builder()
            .email("me2@email.com")
            .firstName("ahmed")
            .lastName("zaky")
            .guardian(guardian)
            .build();

        studentRepository.save(student);
    }

    @Test
    public void printStudentByFirstName() {
        List<Student> students = studentRepository.findByFirstName("ahmed");

        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> students = studentRepository.findByFirstNameContaining("hme");

        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByGuardianName() {
        List<Student> students = studentRepository.findByGuardianName("fouad");

        System.out.println("students = " + students);
    }
}
