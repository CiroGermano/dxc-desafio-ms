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
    private String firstName;

    @Column(name = "PERS_NO_LASTNAME", nullable = false)
    private String lastName;

    @Column(name = "PERS_NO_EMAIL", nullable = false, unique = true)
    private String email;

    @Column(name = "PERS_NU_CPF", nullable = false, unique = true)
    private String cpf;

    public Person() {
    }

    public Person(String nickname, String firstName, String lastName, String email, String cpf) {
        this.nickname = nickname;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.cpf = cpf;
    }

    public Person(Long id, String nickname, String firstName, String lastName, String email, String cpf) {
        this.nickname = nickname;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.cpf = cpf;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + cpf.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return person.cpf.equals(this.cpf);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", nickName='" + nickname + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
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
