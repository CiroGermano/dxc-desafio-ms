package com.ciromoraes.dxcdesafioms.exceptions.handlers;

import com.ciromoraes.dxcdesafioms.exceptions.JsonMessage;
import com.ciromoraes.dxcdesafioms.exceptions.person.CpfAlreadyExistsException;
import com.ciromoraes.dxcdesafioms.exceptions.person.PersonNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PersonExceptionHandler {

    @ExceptionHandler({PersonNotFoundException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public JsonMessage handlePersonNotFoundException(PersonNotFoundException ex){
        return new JsonMessage(ex.getMessage());
    }

    @ExceptionHandler({CpfAlreadyExistsException.class})
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public JsonMessage handleCpfAlreadyExistsException(CpfAlreadyExistsException ex){
        return new JsonMessage(ex.getMessage());
    }
}
