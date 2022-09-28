package com.carlease.boot.carleaseapi.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    private static final long serialVersionUID = -957473736126859864L;

	public ResourceNotFoundException(String message){
        super(message);
    }
}