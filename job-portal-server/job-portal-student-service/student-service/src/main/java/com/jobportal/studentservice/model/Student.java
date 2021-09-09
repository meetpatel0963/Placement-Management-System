package com.jobportal.studentservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

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

}
