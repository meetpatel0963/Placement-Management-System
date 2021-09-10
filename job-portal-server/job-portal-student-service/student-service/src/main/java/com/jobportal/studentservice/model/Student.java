package com.jobportal.studentservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Document(collection="students")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {

    @Id
    private String id;

    // Personal Details
    @Field("personalDetails")
    private PersonalDetails personalDetails;

    // Education Details
    @Field("educationDetails")
    private EducationDetails educationDetails;

    // Contact Details
    @Field("contactDetails")
    private ContactDetails contactDetails;

    // Job Details
    @Field("jobDetails")
    private JobDetails jobDetails;

    @Field("date")
    private String date;

    public Student(String id, PersonalDetails personalDetails, EducationDetails educationDetails,
                   ContactDetails contactDetails, JobDetails jobDetails) {
        this.id = id;
        this.personalDetails = personalDetails;
        this.educationDetails = educationDetails;
        this.contactDetails = contactDetails;
        this.jobDetails = jobDetails;

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        this.date = formatter.format(date);
    }
}
