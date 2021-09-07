package com.jobportal.studentservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class File {

    private String fileId;
    private String filename;
    private String fileType;
    private String fileSize;
    private byte[] file;

    public File(String fileId, String filename, String fileType, String fileSize) {
        this.fileId = fileId;
        this.filename = filename;
        this.fileType = fileType;
        this.fileSize = fileSize;
    }
}
