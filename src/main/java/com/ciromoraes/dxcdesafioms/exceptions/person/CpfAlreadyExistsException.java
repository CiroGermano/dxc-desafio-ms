package com.ciromoraes.dxcdesafioms.exceptions.person;

import com.ciromoraes.dxcdesafioms.entities.Person;

public class CpfAlreadyExistsException extends RuntimeException {

    public CpfAlreadyExistsException(Person person) {
        super("CPF already exists: " + person.getCpf());
    }
}
