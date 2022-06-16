package org.ivanov.domains.repositories;

import org.ivanov.domains.entities.WorkDone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkDoneRepository  extends JpaRepository<WorkDone, Integer> {
    List<WorkDone> findAllByCarId(int carId);
}
