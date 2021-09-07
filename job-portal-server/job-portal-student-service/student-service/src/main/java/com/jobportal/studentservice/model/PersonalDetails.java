package com.jobportal.studentservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PersonalDetails {

    private File profilePicture;
    private String firstName;
    private String middleName;
    private String lastName;
    private String fatherName;
    private String gender;
    private String currentAddressLine1;
    private String currentAddressLine2;
    private String permanentAddressLine1;
    private String permanentAddressLine2;
    private String city;
    private String state;
    private String country;
    private String dob;
    private String nationality;
    private ArrayList<String> articles;

    public PersonalDetails(String firstName, String middleName, String lastName, String fatherName, String gender,
                           String currentAddressLine1, String currentAddressLine2, String permanentAddressLine1,
                           String permanentAddressLine2, String city, String state, String country, String dob,
                           String nationality, ArrayList<String> articles) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.gender = gender;
        this.currentAddressLine1 = currentAddressLine1;
        this.currentAddressLine2 = currentAddressLine2;
        this.permanentAddressLine1 = permanentAddressLine1;
        this.permanentAddressLine2 = permanentAddressLine2;
        this.city = city;
        this.state = state;
        this.country = country;
        this.dob = dob;
        this.nationality = nationality;
        this.articles = articles;
    }
}
