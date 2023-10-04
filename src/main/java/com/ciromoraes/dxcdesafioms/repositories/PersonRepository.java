package com.ciromoraes.dxcdesafioms.repositories;

import com.ciromoraes.dxcdesafioms.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    public Optional<Person> findByCpf(String cpf);

    @Query(value = "SELECT p FROM Person p WHERE p.id = :personId")
    public Optional<Person> findById(@Param("personId") Long id);

    @Modifying
    @Query(value = "DELETE FROM PERSON WHERE PERS_CD_PERSON = ?1", nativeQuery = true)
    public void deleteById(Long id);
}
