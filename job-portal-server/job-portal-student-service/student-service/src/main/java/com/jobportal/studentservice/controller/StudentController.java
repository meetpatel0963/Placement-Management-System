package com.jobportal.studentservice.controller;

import com.jobportal.studentservice.exception.InternalServerErrorException;
import com.jobportal.studentservice.exception.ResourceNotFoundException;
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

    @GetMapping(path = "/contact", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getStudentContactDetails(@RequestBody StudentServiceOuterClass.GetStudentContactRequest getStudentContactRequest) {
        Optional<StudentServiceOuterClass.GetStudentContactResponse> getStudentContactResponse =
                studentService.getStudentContactDetails(getStudentContactRequest);

        return !getStudentContactResponse.isPresent()
                ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResourceNotFoundException("Student", "id"))
                : ResponseEntity.ok(getStudentContactResponse.get());
    }

    @GetMapping(path = "/{studentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getStudentById(@PathVariable String studentId, @RequestBody StudentServiceOuterClass.GetStudentByIdRequest getStudentByIdRequest) {
        Optional<StudentServiceOuterClass.GetStudentByIdResponse> getStudentByIdResponse =
                studentService.getStudentById(studentId, getStudentByIdRequest);
        
        return !getStudentByIdResponse.isPresent()
            ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResourceNotFoundException("Student", "id"))
            : ResponseEntity.ok(getStudentByIdResponse.get());
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveStudent(@RequestBody StudentServiceOuterClass.SaveStudentRequest saveStudentRequest) {
        Optional<StudentServiceOuterClass.SaveStudentResponse> saveStudentResponse =
                studentService.saveStudent(saveStudentRequest);

        return !saveStudentResponse.isPresent()
            ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResourceNotFoundException("Student", "id"))
            : ResponseEntity.status(HttpStatus.CREATED).body(saveStudentResponse.get());
    }

    @PutMapping(path = "/{studentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateStudent(@PathVariable String studentId, @RequestBody StudentServiceOuterClass.UpdateStudentRequest updateStudentRequest) {
        Optional<StudentServiceOuterClass.UpdateStudentResponse> updateStudentResponse =
                studentService.updateStudent(studentId, updateStudentRequest);

        return !updateStudentResponse.isPresent()
            ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new InternalServerErrorException("Could not update a student! Try again!"))
            : ResponseEntity.ok(updateStudentResponse.get());
    }

    @DeleteMapping(path = "/{studentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteStudent(@PathVariable String studentId,
                                           @RequestBody StudentServiceOuterClass.DeleteStudentRequest deleteStudentRequest) {
        Optional<StudentServiceOuterClass.DeleteStudentResponse> deleteStudentResponse =
                studentService.deleteStudent(studentId, deleteStudentRequest);

        return !deleteStudentResponse.isPresent()
            ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResourceNotFoundException("Student", "id"))
            : ResponseEntity.ok(deleteStudentResponse.get());
    }
}
