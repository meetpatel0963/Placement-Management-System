package com.jobportal.studentservice.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
@Getter
@Setter
public class InternalServerErrorException extends RuntimeException {
    private String message;

    public InternalServerErrorException(String message) {
        super(message);
        this.message = message;
    }
}
