package com.xebia.studentevaluationapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer studentId;

    private String firstName;
    private String lastName;


    @JoinColumn(name = "group_id")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Group group;
}