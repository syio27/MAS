package com.baglan.mas.mp5.repository;

import com.baglan.mas.mp5.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByEmail(String email);
}
