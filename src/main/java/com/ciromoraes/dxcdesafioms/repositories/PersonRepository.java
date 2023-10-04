package com.ciromoraes.dxcdesafioms.repositories;

import com.ciromoraes.dxcdesafioms.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    public Optional<Person> findByCpf(String cpf);
}
