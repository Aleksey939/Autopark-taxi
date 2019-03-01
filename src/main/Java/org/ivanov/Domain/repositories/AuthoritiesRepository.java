package org.ivanov.Domain.repositories;

import org.ivanov.Domain.entity.Authorities;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthoritiesRepository extends JpaRepository<Authorities, Integer> {
}
