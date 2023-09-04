package com.zaky.springjpatutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zaky.springjpatutorial.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    
}
