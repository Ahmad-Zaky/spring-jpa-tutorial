package com.zaky.springjpatutorial.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaky.springjpatutorial.entity.Course;
import com.zaky.springjpatutorial.entity.Student;
import com.zaky.springjpatutorial.entity.Teacher;
import com.zaky.springjpatutorial.repository.CourseRepository;
import com.zaky.springjpatutorial.repository.StudentRepository;

@Configuration
public class StudentConfig {
    @Autowired
    private CourseRepository courseRepository;

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Teacher teacher = Teacher.builder()
                .firstName("hady")
                .lastName("zaky")
                .build();
            
            Student student = Student.builder()
                .firstName("maged")
                .lastName("waleed")
                .email("maged@email.com")
                .build();
            
            Course course = Course.builder()
                .title("A course 3")
                .credit(12)
                .teacher(teacher)
                .build();

            course.addStudents(student);

            courseRepository.save(course);
        };
    }

}
