package com.ciromoraes.dxcdesafioms.dto.person;

public class PersonResponseDto {

    private Long id;

    private String nickName;

    private String firstName;

    private String lastName;

    private String email;

    private String cpf;

    public PersonResponseDto() {
    }

    public PersonResponseDto(Long id, String nickName, String firstName, String lastName, String email, String cpf) {
        this.id = id;
        this.nickName = nickName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.cpf = cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonResponseDto)) return false;
        PersonResponseDto personResponseDto = (PersonResponseDto) o;
        return personResponseDto.getId().equals(this.id) && personResponseDto.getCpf().equals(this.cpf);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
