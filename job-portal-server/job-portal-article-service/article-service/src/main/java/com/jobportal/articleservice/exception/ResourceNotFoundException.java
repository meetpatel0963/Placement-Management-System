package com.jobportal.articleservice.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {
    private String resourceName;
    private String fieldName;

    public ResourceNotFoundException(String resourceName, String fieldName) {
        super(String.format("No %s exists with given %s.", resourceName, fieldName));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
    }

}
