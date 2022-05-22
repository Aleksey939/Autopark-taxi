package org.ivanov.domain.repositories;

import org.ivanov.domain.entity.Authorities;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthoritiesRepository extends JpaRepository<Authorities, Integer> {
}
