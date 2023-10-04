package com.ciromoraes.dxcdesafioms.dto.person;

import com.ciromoraes.dxcdesafioms.entities.Person;

public class PersonCreateDto {

    private String nickName;

    private String firstName;

    private String lastName;

    private String email;

    private String cpf;

    public PersonCreateDto() {
    }
    public PersonCreateDto(String nickName, String firstName, String lastName, String email, String cpf) {
        this.nickName = nickName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.cpf = cpf;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
