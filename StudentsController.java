package com.example.libraryplace1.controller;

import com.example.libraryplace1.model.Students;
import com.example.libraryplace1.repository.StudentsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentsController {
    private final StudentsRepository studentsRepository;

    public StudentsController(StudentsRepository studentsRepository) { this.studentsRepository = studentsRepository; }

    @GetMapping("/all")
    public ResponseEntity<List<Students>> getAllStudents() {
        List<Students> students = studentsRepository.findAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Students> getStudentById(@PathVariable ("int id") Long id) {
        Optional<Students> students = studentsRepository.findById(id);
        if (students.isPresent()) {
            return new ResponseEntity<>(students.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/add")
    public ResponseEntity<Students> addStudent(@RequestBody Students students) {
        return new ResponseEntity<>(studentsRepository.save(students),HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Students> updateStudent(@PathVariable("id") Long id, @RequestBody Students students) {
        Optional<Students> studentsOptional= studentsRepository.findById(id);
        if(studentsOptional.isPresent()) {
            students.setId(id);
            return new ResponseEntity<>(studentsRepository.save(students),HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Students> deleteStudent(@PathVariable("id") Long id){
        Optional<Students> students= studentsRepository.findById(id);
        if(students.isPresent()) {
            studentsRepository.delete(students.get());
            return new ResponseEntity<>(students.get(), HttpStatus.OK);

        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
