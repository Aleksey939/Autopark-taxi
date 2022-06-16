package org.ivanov.domains.repositories;

import org.ivanov.domains.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
