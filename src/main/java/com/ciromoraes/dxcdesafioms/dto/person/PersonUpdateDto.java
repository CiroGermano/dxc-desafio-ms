package com.ciromoraes.dxcdesafioms.dto.person;

public class PersonUpdateDto {

    private String nickName;

    private String firstName;

    private String lastName;

    private String email;

    public PersonUpdateDto() {
    }
    public PersonUpdateDto(String nickName, String firstName, String lastName, String email) {
        this.nickName = nickName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
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

}
