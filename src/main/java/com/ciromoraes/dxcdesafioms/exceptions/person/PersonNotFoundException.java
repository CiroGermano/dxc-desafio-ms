package com.ciromoraes.dxcdesafioms.exceptions.person;

public class PersonNotFoundException extends RuntimeException {
    public PersonNotFoundException(Long id) {
        super("Could not find person id: " + id);
    }
}
