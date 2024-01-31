package com.brkbthn.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FIRST_NAME", length = 100, nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", length = 125)
    private String lastname;

    @Column(name = "EMAIL", unique = true)
    private  String email;



   // private int shoolNo;


    }

