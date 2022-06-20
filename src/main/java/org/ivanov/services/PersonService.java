package org.ivanov.services;
import org.ivanov.domains.entities.Person;
import java.util.List;
import java.util.Optional;

public interface PersonService {
    List<Person> findAll();
    Optional<Person> findById(Integer workdoneId);

    Person save(Person person);

    void deleteById(Integer personId);
}
