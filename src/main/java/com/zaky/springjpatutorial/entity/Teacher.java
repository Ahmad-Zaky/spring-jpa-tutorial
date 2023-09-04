package com.zaky.springjpatutorial.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {
    @Id
    @SequenceGenerator(
        name = "teacher_sequence",
        sequenceName = "teacher_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "teacher_sequence"
    )
    private Long id;

    private String firstName;
    
    private String lastName;

    /*
     * NOTE: Prefer ManyToOne relationship,
     * so we implemented the other relationship
     * in the Course Entity class
     */
    // @OneToMany(
    //     cascade = CascadeType.ALL,
    //     fetch = FetchType.LAZY
    // )
    // @JoinColumn(
    //     name = "teacher_id",
    //     referencedColumnName = "id"
    // )
    // private List<Course> courses;
}
