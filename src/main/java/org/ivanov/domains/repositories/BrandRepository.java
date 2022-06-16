package org.ivanov.domains.repositories;

import org.ivanov.domains.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
}
