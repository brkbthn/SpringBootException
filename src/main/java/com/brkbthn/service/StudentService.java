package com.brkbthn.service;

import com.brkbthn.exception.ResourceNotFoundException;
import com.brkbthn.model.Student;
import com.brkbthn.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public List<Student> getAllStudents(){

        return studentRepository.findAll();
    }

    public Student getOneStudent(long id) throws ResourceNotFoundException  {
        //return studentRepository.findById(id).get();
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found , ,id:"+id));

        return ResponseEntity.ok().body(student).getBody();

    }

    public Student creatStudent(Student student){

        return studentRepository.save(student);
    }


    public Map<String, Boolean> deleteOneStudent(long id) throws ResourceNotFoundException{
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found, id:"+id));
        //Eğer sistemde id si verilen öğrenci varsa yoluna devam eder yoksa bir üst satırda duru ve istina fırlatır
        studentRepository.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Silinme işlemi başarıyla tamamlanmıstır.", Boolean.TRUE);
        return response;
    }

    public ResponseEntity<Student> updateStudent(Student st) throws ResourceNotFoundException{
         Student student = studentRepository.findById(st.getId())
                 .orElseThrow(() -> new ResourceNotFoundException("Student not found, id:"+st.getId()));

         return ResponseEntity.ok(studentRepository.save(st));
    }
}
