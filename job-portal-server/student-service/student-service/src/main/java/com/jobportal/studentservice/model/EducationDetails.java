package com.jobportal.studentservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class EducationDetails {

    Map<String, String> SSCDetails;
    Map<String, String> HSCDetails;
    Map<String, String> DiplomaDetails;
    Map<String, String> UGDetails;
    Map<String, String> PGDetails;

}
