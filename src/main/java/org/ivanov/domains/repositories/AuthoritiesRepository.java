package org.ivanov.domains.repositories;

import org.ivanov.domains.entities.Authorities;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthoritiesRepository extends JpaRepository<Authorities, Integer> {
}
