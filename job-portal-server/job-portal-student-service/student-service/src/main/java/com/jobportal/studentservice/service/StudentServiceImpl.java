package com.jobportal.studentservice.service;

import com.google.protobuf.ByteString;
import com.jobportal.studentservice.exception.ResourceNotFoundException;
import com.jobportal.studentservice.model.ContactDetails;
import com.jobportal.studentservice.model.EducationDetails;
import com.jobportal.studentservice.model.JobDetails;
import com.jobportal.studentservice.model.PersonalDetails;
import com.jobportal.studentservice.model.Student;
import com.jobportal.studentservice.repository.StudentRepository;
import com.jobportal.studentserviceproto.StudentServiceOuterClass;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.List;

@GrpcService
@CrossOrigin(origins = "http://localhost:8080")
public class StudentServiceImpl extends com.jobportal.studentserviceproto.StudentServiceGrpc.StudentServiceImplBase {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> findAllById(List<StudentServiceOuterClass.GetStudentContactRequest.StudentId> studentIds) {
        List<Student> students = new ArrayList<Student>();
        for(StudentServiceOuterClass.GetStudentContactRequest.StudentId studentId : studentIds) {
            Student student = studentRepository.findById(studentId.getStudentId())
                    .orElseThrow(() -> new ResourceNotFoundException("Student", "id", studentId.getStudentId()));
            students.add(student);
        }
        return students;
    }

    public StudentServiceOuterClass.Student getStudentDetailsFromModel(Student student) {
        PersonalDetails personalDetails = student.getPersonalDetails();
        com.jobportal.studentservice.model.File profilePicture = student.getPersonalDetails().getProfilePicture();
        ContactDetails contactDetails = student.getContactDetails();
        EducationDetails educationDetails = student.getEducationDetails();
        JobDetails jobDetails = student.getJobDetails();

        StudentServiceOuterClass.File studentProfilePicture = StudentServiceOuterClass.File.newBuilder()
                .setFileName(profilePicture.getFilename())
                .setFileType(profilePicture.getFileType())
                .setFileSize(profilePicture.getFileSize())
                .setFile(ByteString.copyFrom(profilePicture.getFile()))
                .build();

        StudentServiceOuterClass.PersonalDetails studentPersonalDetails =
                StudentServiceOuterClass.PersonalDetails.newBuilder()
                        .setProfilePicture(studentProfilePicture)
                        .setFirstName(personalDetails.getFirstName())
                        .setMiddleName(personalDetails.getMiddleName())
                        .setLastName(personalDetails.getLastName())
                        .setFatherName(personalDetails.getFatherName())
                        .setGender(personalDetails.getGender())
                        .setCurrentAddressLine1(personalDetails.getCurrentAddressLine1())
                        .setCurrentAddressLine2(personalDetails.getCurrentAddressLine2())
                        .setPermanentAddressLine1(personalDetails.getPermanentAddressLine1())
                        .setPermanentAddressLine2(personalDetails.getPermanentAddressLine2())
                        .setCity(personalDetails.getCity())
                        .setState(personalDetails.getState())
                        .setCountry(personalDetails.getCountry())
                        .setDob(personalDetails.getDob())
                        .setNationality(personalDetails.getNationality())
                        .addAllArticles(personalDetails.getArticles())
                        .build();

        StudentServiceOuterClass.ContactDetails studentContactDetails =
                StudentServiceOuterClass.ContactDetails.newBuilder()
                        .setPrimaryEmailId(contactDetails.getPrimaryEmailId())
                        .setSecondaryEmailId(contactDetails.getSecondaryEmailId())
                        .setPhoneNumber(contactDetails.getPhoneNumber())
                        .setAltPhoneNumber(contactDetails.getAltPhoneNumber())
                        .setAltPhoneNumberBelongsTo(contactDetails.getAltPhoneNumberBelongsTo())
                        .setLinkedInId(contactDetails.getLinkedInId())
                        .setSkypeId(contactDetails.getSkypeId())
                        .build();

        StudentServiceOuterClass.EducationDetails studentEducationDetails =
                StudentServiceOuterClass.EducationDetails.newBuilder()
                        .putAllSSCDetails(educationDetails.getSSCDetails())
                        .putAllHSCDetails(educationDetails.getHSCDetails())
                        .putAllDiplomaDetails(educationDetails.getDiplomaDetails())
                        .putAllUGDetails(educationDetails.getUGDetails())
                        .putAllPGDetails(educationDetails.getPGDetails())
                        .build();

        StudentServiceOuterClass.JobDetails studentJobDetails =
                StudentServiceOuterClass.JobDetails.newBuilder()
                        .addAllSkills(jobDetails.getSkills())
                        .setExperienceType(jobDetails.getExperienceType())
                        .setExperiencePeriodInMonths(jobDetails.getExperiencePeriodInMonths())
                        .setExperiencePeriodInYears(jobDetails.getExperiencePeriodInYears())
                        .build();

        StudentServiceOuterClass.Student studentDetails = StudentServiceOuterClass.Student.newBuilder()
                .setId(student.getId())
                .setPersonalDetails(studentPersonalDetails)
                .setContactDetails(studentContactDetails)
                .setEducationDetails(studentEducationDetails)
                .setJobDetails(studentJobDetails)
                .build();

        return studentDetails;
    }

    Student getStudentDetailsFromProto(StudentServiceOuterClass.Student student) {
        StudentServiceOuterClass.ContactDetails contactDetails = student.getContactDetails();
        StudentServiceOuterClass.EducationDetails educationDetails = student.getEducationDetails();
        StudentServiceOuterClass.PersonalDetails personalDetails = student.getPersonalDetails();
        StudentServiceOuterClass.JobDetails jobDetails = student.getJobDetails();

        PersonalDetails studentPersonalDetails =
                new PersonalDetails(
                        personalDetails.getFirstName(),
                        personalDetails.getMiddleName(),
                        personalDetails.getLastName(),
                        personalDetails.getFatherName(),
                        personalDetails.getGender(),
                        personalDetails.getCurrentAddressLine1(),
                        personalDetails.getCurrentAddressLine2(),
                        personalDetails.getPermanentAddressLine1(),
                        personalDetails.getPermanentAddressLine2(),
                        personalDetails.getCity(),
                        personalDetails.getState(),
                        personalDetails.getCountry(),
                        personalDetails.getDob(),
                        personalDetails.getNationality(),
                        new ArrayList<>(personalDetails.getArticlesList()));

        ContactDetails studentContactDetails =
                new ContactDetails(
                        contactDetails.getPrimaryEmailId(),
                        contactDetails.getSecondaryEmailId(),
                        contactDetails.getPhoneNumber(),
                        contactDetails.getAltPhoneNumber(),
                        contactDetails.getAltPhoneNumberBelongsTo(),
                        contactDetails.getLinkedInId(),
                        contactDetails.getSkypeId());

        EducationDetails studentEducationDetails =
                new EducationDetails(
                        educationDetails.getSSCDetailsMap(),
                        educationDetails.getHSCDetailsMap(),
                        educationDetails.getDiplomaDetailsMap(),
                        educationDetails.getUGDetailsMap(),
                        educationDetails.getPGDetailsMap());

        JobDetails studentJobDetails =
                new JobDetails(
                        new ArrayList<>(jobDetails.getSkillsList()),
                        jobDetails.getExperienceType(),
                        jobDetails.getExperiencePeriodInMonths(),
                        jobDetails.getExperiencePeriodInYears());

        Student studentDetails = new Student(
                student.getId(),
                studentPersonalDetails,
                studentEducationDetails,
                studentContactDetails,
                studentJobDetails
        );

        return studentDetails;
    }

    @Override
    public void getStudentContactDetails(StudentServiceOuterClass.GetStudentContactRequest request,
                                         StreamObserver<StudentServiceOuterClass.GetStudentContactResponse> responseObserver) {
        List<StudentServiceOuterClass.GetStudentContactRequest.StudentId> studentsIds = request.getStudentIdsList();
        List<Student> students = findAllById(studentsIds);

        List<StudentServiceOuterClass.GetStudentContactResponse.StudentContactDetails> studentContactDetailsList =
                new ArrayList<StudentServiceOuterClass.GetStudentContactResponse.StudentContactDetails>();

        for(Student student : students) {
            PersonalDetails studentPersonalDetails = student.getPersonalDetails();
            ContactDetails studentContactDetails = student.getContactDetails();

            StudentServiceOuterClass.GetStudentContactResponse.StudentContactDetails studentDetails = StudentServiceOuterClass.GetStudentContactResponse.StudentContactDetails.newBuilder()
                    .setFirstName(studentPersonalDetails.getFirstName())
                    .setMiddleName(studentPersonalDetails.getMiddleName())
                    .setLastName(studentPersonalDetails.getLastName())
                    .setPrimaryEmailId(studentContactDetails.getPrimaryEmailId())
                    .setPhoneNumber(studentContactDetails.getPhoneNumber())
                    .setLinkedInId(studentContactDetails.getLinkedInId())
                    .build();

            studentContactDetailsList.add(studentDetails);
        }

        StudentServiceOuterClass.GetStudentContactResponse studentResponse = StudentServiceOuterClass.GetStudentContactResponse.newBuilder()
                .addAllStudents(studentContactDetailsList)
                .build();

        responseObserver.onNext(studentResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void getAllStudents(StudentServiceOuterClass.GetAllStudentsRequest request, StreamObserver<StudentServiceOuterClass.GetAllStudentsResponse> responseObserver) {
        List<Student> students = studentRepository.findAll();

        List<StudentServiceOuterClass.Student> studentsList =
                new ArrayList<StudentServiceOuterClass.Student>();

        for(Student student : students) {
            studentsList.add(getStudentDetailsFromModel(student));
        }

        StudentServiceOuterClass.GetAllStudentsResponse allStudents = StudentServiceOuterClass.GetAllStudentsResponse.newBuilder()
                .addAllStudents(studentsList)
                .build();

        responseObserver.onNext(allStudents);
        responseObserver.onCompleted();
    }

    @Override
    public void getStudentById(StudentServiceOuterClass.GetStudentByIdRequest request, StreamObserver<StudentServiceOuterClass.GetStudentByIdResponse> responseObserver) {
        Student student =
                studentRepository.findById(request.getStudentId())
                        .orElseThrow(() -> new ResourceNotFoundException("Student", "id", request.getStudentId()));

        StudentServiceOuterClass.GetStudentByIdResponse studentDetails = StudentServiceOuterClass.GetStudentByIdResponse.newBuilder()
                .setStudent(getStudentDetailsFromModel(student))
                .build();

        responseObserver.onNext(studentDetails);
        responseObserver.onCompleted();
    }

    @Override
    public void saveStudent(StudentServiceOuterClass.SaveStudentRequest request, StreamObserver<StudentServiceOuterClass.SaveStudentResponse> responseObserver) {
        studentRepository.save(getStudentDetailsFromProto(request.getStudent()));
        StudentServiceOuterClass.SaveStudentResponse message = StudentServiceOuterClass.SaveStudentResponse.newBuilder()
                .setMessage("New Student Added!")
                .build();

        responseObserver.onNext(message);
        responseObserver.onCompleted();
    }

    @Override
    public void updateStudent(StudentServiceOuterClass.UpdateStudentRequest request, StreamObserver<StudentServiceOuterClass.UpdateStudentResponse> responseObserver) {
        Student student = studentRepository.findById(request.getStudent().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Student", "id", request.getStudent().getId()));

        Student newStudent = getStudentDetailsFromProto(request.getStudent());

        studentRepository.save(newStudent);

        StudentServiceOuterClass.UpdateStudentResponse message = StudentServiceOuterClass.UpdateStudentResponse.newBuilder()
                .setMessage("Student Updated Successfully!")
                .build();

        responseObserver.onNext(message);
        responseObserver.onCompleted();
    }

    @Override
    public void deleteStudent(StudentServiceOuterClass.DeleteStudentRequest request, StreamObserver<StudentServiceOuterClass.DeleteStudentResponse> responseObserver) {
        Student student = studentRepository.findById(request.getStudentId())
                .orElseThrow(() -> new ResourceNotFoundException("Student", "id", request.getStudentId()));

        studentRepository.delete(student);

        StudentServiceOuterClass.DeleteStudentResponse message = StudentServiceOuterClass.DeleteStudentResponse.newBuilder()
                .setMessage("Student Deleted Successfully!")
                .build();

        responseObserver.onNext(message);
        responseObserver.onCompleted();
    }
}
