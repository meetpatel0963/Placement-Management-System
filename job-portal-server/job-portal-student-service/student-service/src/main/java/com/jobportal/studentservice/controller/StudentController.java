package com.jobportal.studentservice.controller;

import com.jobportal.studentservice.exception.InternalServerErrorException;
import com.jobportal.studentservice.exception.ResourceNotFoundException;
import com.jobportal.studentservice.service.StudentService;
import com.jobportal.studentserviceproto.StudentServiceOuterClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.util.Optional;

@RefreshScope
@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Value("${project.name}")
    private String projectName;

    @GetMapping("/projectname")
    public String getProjectName() {
        return "Project Name : [" + this.projectName + "]";
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents(StudentServiceOuterClass.GetAllStudentsRequest.newBuilder().build()));
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
    public ResponseEntity<?> getStudentById(@PathVariable String studentId) {
        StudentServiceOuterClass.GetStudentByIdRequest getStudentByIdRequest =
                StudentServiceOuterClass.GetStudentByIdRequest.newBuilder()
                        .setStudentId(studentId)
                        .build();

        Optional<StudentServiceOuterClass.GetStudentByIdResponse> getStudentByIdResponse =
                studentService.getStudentById(getStudentByIdRequest);
        
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
    public ResponseEntity<?> deleteStudent(@PathVariable String studentId) {
        StudentServiceOuterClass.DeleteStudentRequest deleteStudentRequest =
                StudentServiceOuterClass.DeleteStudentRequest.newBuilder()
                        .setStudentId(studentId)
                        .build();

        Optional<StudentServiceOuterClass.DeleteStudentResponse> deleteStudentResponse =
                studentService.deleteStudent(deleteStudentRequest);

        return !deleteStudentResponse.isPresent()
            ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResourceNotFoundException("Student", "id"))
            : ResponseEntity.ok(deleteStudentResponse.get());
    }

    @PostMapping(path = "/register-student", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registerStudentForJob(@RequestBody StudentServiceOuterClass.RegisterStudentForJobRequest registerStudentForJobRequest) {
        Optional<StudentServiceOuterClass.RegisterStudentForJobResponse> registerStudentForJobResponse =
                studentService.registerStudentForJob(registerStudentForJobRequest);

        return !registerStudentForJobResponse.isPresent()
                ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResourceNotFoundException("Student", "id"))
                : ResponseEntity.ok(registerStudentForJobResponse.get());
    }

    @GetMapping(path = "/{jobId}/students", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getRegisteredStudentsByJobId(@PathVariable String jobId) {
        StudentServiceOuterClass.GetRegisteredStudentsByJobIdRequest getRegisteredStudentsByJobIdRequest =
                StudentServiceOuterClass.GetRegisteredStudentsByJobIdRequest.newBuilder()
                        .setJobId(jobId)
                        .build();

        Optional<StudentServiceOuterClass.GetRegisteredStudentsByJobIdResponse> getRegisteredStudentsByJobIdResponse =
                studentService.getRegisteredStudentsByJobId(getRegisteredStudentsByJobIdRequest);

        return !getRegisteredStudentsByJobIdResponse.isPresent()
                ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResourceNotFoundException("Student", "id"))
                : ResponseEntity.ok(getRegisteredStudentsByJobIdResponse.get());
    }
}
