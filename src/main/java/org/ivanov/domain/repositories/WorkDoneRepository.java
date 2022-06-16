package org.ivanov.domain.repositories;

import org.ivanov.domain.entity.WorkDone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkDoneRepository  extends JpaRepository<WorkDone, Integer> {
    List<WorkDone> findAllByCarId(int carId);
}
