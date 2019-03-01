package org.ivanov.Domain.repositories;

import org.ivanov.Domain.entity.Brand;
import org.ivanov.Domain.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
}
