package com.jobportal.studentservice.service;

import com.google.protobuf.ByteString;
import com.jobportal.studentservice.model.*;
import com.jobportal.studentservice.repository.StudentRepository;
import com.jobportal.studentserviceproto.StudentServiceOuterClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private FileService fileService;

    public Optional<StudentServiceOuterClass.Student> getStudentDetailsFromModel(Student student) {
        PersonalDetails personalDetails = student.getPersonalDetails();
        ContactDetails contactDetails = student.getContactDetails();
        EducationDetails educationDetails = student.getEducationDetails();
        JobDetails jobDetails = student.getJobDetails();

        String profilePictureId = personalDetails.getProfilePicture().getFileId();
        File studentProfilePicture =
                fileService.findById(profilePictureId).orElse(personalDetails.getProfilePicture());

        StudentServiceOuterClass.File profilePicture = StudentServiceOuterClass.File.newBuilder()
                .setFileName(studentProfilePicture.getFilename())
                .setFileType(studentProfilePicture.getFileType())
                .setFileSize(studentProfilePicture.getFileSize())
                .setFile(ByteString.copyFrom(studentProfilePicture.getFile()))
                .build();

        StudentServiceOuterClass.PersonalDetails studentPersonalDetails =
                StudentServiceOuterClass.PersonalDetails.newBuilder()
                        .setProfilePicture(profilePicture)
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

        return Optional.ofNullable(studentDetails);
    }

    Optional<Student> getStudentDetailsFromProto(StudentServiceOuterClass.Student student) {
        StudentServiceOuterClass.ContactDetails contactDetails = student.getContactDetails();
        StudentServiceOuterClass.EducationDetails educationDetails = student.getEducationDetails();
        StudentServiceOuterClass.PersonalDetails personalDetails = student.getPersonalDetails();
        StudentServiceOuterClass.File profilePicture = student.getPersonalDetails().getProfilePicture();
        StudentServiceOuterClass.JobDetails jobDetails = student.getJobDetails();

        Optional<Student> _student = studentRepository.findById(student.getId());

        File studentProfilePicture = new File(
                _student.isPresent() ? _student.get().getPersonalDetails().getProfilePicture().getFileId() : "",
                profilePicture.getFileName(),
                profilePicture.getFileType(),
                profilePicture.getFileSize(),
                profilePicture.getFile().toByteArray());

        PersonalDetails studentPersonalDetails =
                new PersonalDetails(
                        studentProfilePicture,
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

        return Optional.ofNullable(studentDetails);
    }

    public Optional<List<Student>> findAllById(List<StudentServiceOuterClass.GetStudentContactRequest.StudentId> studentIds) {
        List<Student> students = new ArrayList<Student>();
        for(StudentServiceOuterClass.GetStudentContactRequest.StudentId studentId : studentIds) {
            Optional<Student> student = studentRepository.findById(studentId.getStudentId());

            if(!student.isPresent()) {
                return Optional.empty();
            } else {
                students.add(student.get());
            }
        }

        return Optional.ofNullable(students);
    }

    public StudentServiceOuterClass.GetAllStudentsResponse getAllStudents(StudentServiceOuterClass.GetAllStudentsRequest request) {
        List<Student> students = studentRepository.findAll();

        List<StudentServiceOuterClass.Student> studentsList =
                new ArrayList<StudentServiceOuterClass.Student>();

        for(Student student : students) {
            Optional<StudentServiceOuterClass.Student> studentProto = getStudentDetailsFromModel(student);
             studentsList.add(studentProto.get());
        }

        return StudentServiceOuterClass.GetAllStudentsResponse.newBuilder()
                .addAllStudents(studentsList)
                .build();
    }

    public StudentServiceOuterClass.GetStudentContactResponse getStudentContactDetails(StudentServiceOuterClass.GetStudentContactRequest request) {
        List<StudentServiceOuterClass.GetStudentContactRequest.StudentId> studentsIds = request.getStudentIdsList();
        Optional<List<Student>> students = findAllById(studentsIds);

        List<StudentServiceOuterClass.GetStudentContactResponse.StudentContactDetails> studentContactDetailsList =
                    new ArrayList<StudentServiceOuterClass.GetStudentContactResponse.StudentContactDetails>();

        for (Student student : students.get()) {
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

        return StudentServiceOuterClass.GetStudentContactResponse.newBuilder()
                .addAllStudents(studentContactDetailsList)
                .build();
    }

    public StudentServiceOuterClass.GetStudentByIdResponse getStudentById(StudentServiceOuterClass.GetStudentByIdRequest request) {
        Optional<Student> student =
                studentRepository.findById(request.getStudentId());

        Optional<StudentServiceOuterClass.Student> studentProto = getStudentDetailsFromModel(student.get());

        return StudentServiceOuterClass.GetStudentByIdResponse.newBuilder()
                        .setStudent(studentProto.get())
                        .build();
    }

    public StudentServiceOuterClass.SaveStudentResponse saveStudent(StudentServiceOuterClass.SaveStudentRequest request) {
        Optional<Student> student = getStudentDetailsFromProto(request.getStudent());

        File studentProfilePicture = student.get().getPersonalDetails().getProfilePicture();

        BASE64DecodedMultipartFile multipartFile =
                new BASE64DecodedMultipartFile(
                        studentProfilePicture.getFile(),
                        studentProfilePicture.getFilename(),
                        studentProfilePicture.getFileType());

        Optional<String> fileId = fileService.addFile(multipartFile);

        student.get().getPersonalDetails().getProfilePicture().setFileId(fileId.get());
        studentRepository.save(student.get());

        return StudentServiceOuterClass.SaveStudentResponse.newBuilder()
                .setMessage("New Student Added!")
                .build();
    }

    public StudentServiceOuterClass.UpdateStudentResponse updateStudent(StudentServiceOuterClass.UpdateStudentRequest request) {
        Optional<Student> student = studentRepository.findById(request.getStudent().getId());

        Optional<Student> newStudent = getStudentDetailsFromProto(request.getStudent());

        File studentProfilePicture =
                newStudent.get().getPersonalDetails().getProfilePicture();

        Optional<File> profilePicture =
                fileService.findById(studentProfilePicture.getFileId());

        if (studentProfilePicture.getFile() != null && studentProfilePicture.getFile() != profilePicture.get().getFile()) {
            fileService.deleteFile(student.get().getPersonalDetails().getProfilePicture().getFileId());

            BASE64DecodedMultipartFile multipartFile =
                    new BASE64DecodedMultipartFile(
                            studentProfilePicture.getFile(),
                            studentProfilePicture.getFilename(),
                            studentProfilePicture.getFileType());

            Optional<String> fileId = fileService.addFile(multipartFile);
            newStudent.get().getPersonalDetails().getProfilePicture().setFileId(fileId.get());
            studentRepository.save(newStudent.get());
        }

        return StudentServiceOuterClass.UpdateStudentResponse.newBuilder()
                .setMessage("Student Updated Successfully!")
                .build();
    }

    public StudentServiceOuterClass.DeleteStudentResponse deleteStudent(StudentServiceOuterClass.DeleteStudentRequest request) {
        Optional<Student> student = studentRepository.findById(request.getStudentId());

        fileService.deleteFile(student.get().getPersonalDetails().getProfilePicture().getFileId());
        studentRepository.delete(student.get());

        return StudentServiceOuterClass.DeleteStudentResponse.newBuilder()
                .setMessage("Student Deleted Successfully!")
                .build();
    }
}
