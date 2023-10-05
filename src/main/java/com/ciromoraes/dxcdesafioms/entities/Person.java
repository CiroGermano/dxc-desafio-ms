package com.ciromoraes.dxcdesafioms.entities;

import javax.persistence.*;

@Entity
@Table(name = "PERSON")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PERS_CD_PERSON", nullable = false, unique = true)
    private Long id;

    @Column(name = "PERS_NO_NICKNAME", nullable = false, unique = true)
    private String nickname;

    @Column(name = "PERS_NO_FIRSTNAME", nullable = false)
    private String firstname;

    @Column(name = "PERS_NO_LASTNAME", nullable = false)
    private String lastname;

    @Column(name = "PERS_NO_EMAIL", nullable = false, unique = true)
    private String email;

    @Column(name = "PERS_NU_CPF", nullable = false, unique = true)
    private String cpf;

    public Person() {
    }

    public Person(String nickname, String firstname, String lastname, String email, String cpf) {
        this.nickname = nickname;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.cpf = cpf;
    }

    public Person(Long id, String nickname, String firstname, String lastname, String email, String cpf) {
        this.id = id;
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

        Person person = (Person) o;

        if (!id.equals(person.id)) return false;
        return cpf.equals(person.cpf);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + cpf.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", nickName='" + nickname + '\'' +
                ", firstName='" + firstname + '\'' +
                ", lastName='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickName) {
        this.nickname = nickName;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstName) {
        this.firstname = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastName) {
        this.lastname = lastName;
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
