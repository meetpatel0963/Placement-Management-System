package com.jobportal.studentservice.controller;

import com.jobportal.studentservice.config.LogGrpcInterceptor;
import com.jobportal.studentservice.service.StudentService;
import com.jobportal.studentserviceproto.StudentServiceOuterClass;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@GrpcService(interceptors = { LogGrpcInterceptor.class })
@CrossOrigin(origins = "http://localhost:8080")
public class GrpcController extends com.jobportal.studentserviceproto.StudentServiceGrpc.StudentServiceImplBase {

    @Autowired
    private StudentService studentService;

    @Override
    public void getStudentContactDetails(StudentServiceOuterClass.GetStudentContactRequest request,
                                         StreamObserver<StudentServiceOuterClass.GetStudentContactResponse> responseObserver) {
        Optional<StudentServiceOuterClass.GetStudentContactResponse> studentContactResponse =
                studentService.getStudentContactDetails(request);

        if(!studentContactResponse.isPresent()) {
            responseObserver.onError(Status.NOT_FOUND.withDescription("No student exists with given Id!").asRuntimeException());
        } else {
            responseObserver.onNext(studentContactResponse.get());
        }
        responseObserver.onCompleted();
    }

    @Override
    public void getAllStudents(StudentServiceOuterClass.GetAllStudentsRequest request, StreamObserver<StudentServiceOuterClass.GetAllStudentsResponse> responseObserver) {
        responseObserver.onNext(studentService.getAllStudents(request));
        responseObserver.onCompleted();
    }

    @Override
    public void getStudentById(StudentServiceOuterClass.GetStudentByIdRequest request, StreamObserver<StudentServiceOuterClass.GetStudentByIdResponse> responseObserver) {
        Optional<StudentServiceOuterClass.GetStudentByIdResponse> getStudentByIdResponse =
                studentService.getStudentById(request.getStudentId(), request);

        if(!getStudentByIdResponse.isPresent()) {
            responseObserver.onError(Status.NOT_FOUND.withDescription("No student exists with given Id!").asRuntimeException());
        } else {
            responseObserver.onNext(getStudentByIdResponse.get());
        }

        responseObserver.onCompleted();
    }

    @Override
    public void saveStudent(StudentServiceOuterClass.SaveStudentRequest request, StreamObserver<StudentServiceOuterClass.SaveStudentResponse> responseObserver) {
        Optional<StudentServiceOuterClass.SaveStudentResponse> saveStudentResponse =
                studentService.saveStudent(request);

        if(!saveStudentResponse.isPresent()) {
            responseObserver.onError(Status.UNKNOWN.withDescription("Could not save a student! Try again!").asRuntimeException());
        } else {
            responseObserver.onNext(saveStudentResponse.get());
        }
        responseObserver.onCompleted();
    }

    @Override
    public void updateStudent(StudentServiceOuterClass.UpdateStudentRequest request, StreamObserver<StudentServiceOuterClass.UpdateStudentResponse> responseObserver) {
        Optional<StudentServiceOuterClass.UpdateStudentResponse> updateStudentResponse =
                studentService.updateStudent(request.getStudent().getId(), request);

        if(!updateStudentResponse.isPresent()) {
            responseObserver.onError(Status.UNKNOWN.withDescription("Could not update a student! Try again!").asRuntimeException());
        } else {
            responseObserver.onNext(updateStudentResponse.get());
        }
        responseObserver.onCompleted();
    }

    @Override
    public void deleteStudent(StudentServiceOuterClass.DeleteStudentRequest request, StreamObserver<StudentServiceOuterClass.DeleteStudentResponse> responseObserver) {
        Optional<StudentServiceOuterClass.DeleteStudentResponse> deleteStudentResponse =
                studentService.deleteStudent(request.getStudentId(), request);

        if(!deleteStudentResponse.isPresent()) {
            responseObserver.onError(Status.NOT_FOUND.withDescription("No student exists with given Id!").asRuntimeException());
        } else {
            responseObserver.onNext(deleteStudentResponse.get());
        }
        responseObserver.onCompleted();
    }
}
