package com.ciromoraes.dxcdesafioms.dto.person;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotBlank;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonCreateDto {

    @NotBlank(message = "Nickname is mandatory")
    private String nickname;

    @NotBlank(message = "Firstname is mandatory")
    private String firstname;

    @NotBlank(message = "Lastname is mandatory")
    private String lastname;

    @NotBlank(message = "Email is mandatory")
    private String email;

    @NotBlank(message = "Cpf is mandatory")
    private String cpf;

    public PersonCreateDto() {
    }

    public PersonCreateDto(String nickname, String firstname, String lastname, String email, String cpf) {
        this.nickname = nickname;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.cpf = cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonCreateDto that = (PersonCreateDto) o;

        if (!nickname.equals(that.nickname)) return false;
        return cpf.equals(that.cpf);
    }

    @Override
    public int hashCode() {
        int result = nickname.hashCode();
        result = 31 * result + cpf.hashCode();
        return result;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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
