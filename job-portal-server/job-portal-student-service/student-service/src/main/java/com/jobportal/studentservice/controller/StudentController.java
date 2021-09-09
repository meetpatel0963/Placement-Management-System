package com.jobportal.studentservice.controller;

import com.jobportal.studentservice.model.Student;
import com.jobportal.studentservice.service.StudentService;
import com.jobportal.studentserviceproto.StudentServiceOuterClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllStudents(@RequestBody StudentServiceOuterClass.GetAllStudentsRequest getAllStudentsRequest) {
        return ResponseEntity.ok(studentService.getAllStudents(getAllStudentsRequest));
    }

    @GetMapping(path = "/contact/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getStudentContactDetails(@RequestBody StudentServiceOuterClass.GetStudentContactRequest getStudentContactRequest) {
        return ResponseEntity.ok(studentService.getStudentContactDetails(getStudentContactRequest));
    }

    @GetMapping(path = "/id", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getStudentById(@RequestBody StudentServiceOuterClass.GetStudentByIdRequest getStudentByIdRequest) {
        return ResponseEntity.ok(studentService.getStudentById(getStudentByIdRequest));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveStudent(@RequestBody StudentServiceOuterClass.SaveStudentRequest saveStudentRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.saveStudent(saveStudentRequest));
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateStudent(@RequestBody StudentServiceOuterClass.UpdateStudentRequest updateStudentRequest) {
        return ResponseEntity.ok(studentService.updateStudent(updateStudentRequest));
    }

    @DeleteMapping(path = "/id", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteStudent(@RequestBody StudentServiceOuterClass.DeleteStudentRequest deleteStudentRequest) {
        return ResponseEntity.ok(studentService.deleteStudent(deleteStudentRequest));
    }
}
