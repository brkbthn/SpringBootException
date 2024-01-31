package com.brkbthn.repository;

import com.brkbthn.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {//generic kısmın ikinci değişkeni id değerinden gelir
}

