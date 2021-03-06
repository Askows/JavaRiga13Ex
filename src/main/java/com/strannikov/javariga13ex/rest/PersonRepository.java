package com.strannikov.javariga13ex.rest;

import com.strannikov.javariga13ex.rest.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {

    List<Person> findByName(String name);
    Optional<Person> findByAge(int age);

}
