package org.ivanov.Domain.repositories;

import org.ivanov.Domain.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
