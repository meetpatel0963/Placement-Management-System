package com.jobportal.studentservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ContactDetails {

    private String primaryEmailId;
    private String secondaryEmailId;
    private String phoneNumber;
    private String altPhoneNumber;
    private String altPhoneNumberBelongsTo;
    private String linkedInId;
    private String skypeId;

}
