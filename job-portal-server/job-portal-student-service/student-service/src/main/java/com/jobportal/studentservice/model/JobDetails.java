package com.jobportal.studentservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JobDetails {

    private ArrayList<String> skills;
    private String experienceType;
    private int experiencePeriodInYears;
    private int experiencePeriodInMonths;

}
