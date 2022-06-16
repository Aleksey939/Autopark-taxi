package org.ivanov.domains.repositories;

import org.ivanov.domains.entities.WorkDone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkDoneRepository  extends JpaRepository<WorkDone, Integer> {
    @Query("select distinct  wd from WorkDone wd where wd.car.id=:carId")
    List<WorkDone> findAllByCarId(int carId);
}
