package com.brkbthn.controller;

import com.brkbthn.exception.ResourceNotFoundException;
import com.brkbthn.model.Student;
import com.brkbthn.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class StudentController {
    @Autowired
    StudentService studentService;

    //http://localhost8090/api/v1/students
    @GetMapping("/students")
    public List<Student> getAllStudents(){

        return studentService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public Student getOneStudent(@PathVariable(value = "id") long id) throws ResourceNotFoundException {

        return studentService.getOneStudent(id);

    }

    @PostMapping("/students")
    public Student creatStudent(@RequestBody Student student){

        return studentService.creatStudent(student);
    }
    @DeleteMapping("students/{id}")
    public Map<String, Boolean> deleteOneStudent(@PathVariable long id) throws ResourceNotFoundException{

        return studentService.deleteOneStudent(id);
    }
    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable(value = "id") long id,@RequestBody Student student) throws ResourceNotFoundException{
 /*       Student st = studentService.getOneStudent(id);
        if (st != null){
            st.setId(id);
            st.setFirstName(student.getFirstName());
            st.setLastname(student.getLastname());
            st.setEmail(student.getEmail());
        }
        return studentService.updateStudent(st);

  */
        student.setId(id);
        return studentService.updateStudent(student);
    }

}
