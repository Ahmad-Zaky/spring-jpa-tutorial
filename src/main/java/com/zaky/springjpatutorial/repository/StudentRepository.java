package com.zaky.springjpatutorial.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zaky.springjpatutorial.entity.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    public List<Student> findByFirstName(String firstName);
    
    public List<Student> findByFirstNameContaining(String name);
    
    public List<Student> findByGuardianName(String guardianName);

    // JPQL
    @Query("select s from Student s where s.email = ?1")
    public List<Student> getStudentByEmail(String email);

    // JPQL
    @Query("select s.firstName from Student s where s.email = ?1")
    public String getStudentFirstNameByEmail(String email);

    // Native
    @Query(
        value = "SELECT * FROM  tbl_student AS s WHERE s.email = ?1",
        nativeQuery = true
    )
    public List<Student> getStudentFirstNameByEmailNative(String email);

    // Native Named Param
    @Query(
        value = "SELECT * FROM  tbl_student AS s WHERE s.email = :email",
        nativeQuery = true
    )
    public List<Student> getStudentFirstNameByEmailNativeNamedParam(@Param("email") String email);

    // Native Named Param Update
    @Modifying
    @Transactional
    @Query(
        value = "UPDATE tbl_student set first_name = :first_name where email = :email",
        nativeQuery = true
    )
    public int updateStudentFirstNameByEmail(@Param("first_name") String firstName, @Param("email") String email);
}
