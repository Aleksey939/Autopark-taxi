package org.ivanov.service;


import org.ivanov.domains.entities.WorkDone;



import java.util.List;
import java.util.Optional;

public interface WorkDoneService {
    List<WorkDone> findAll();
    Optional<WorkDone> findById(Integer workdoneId);
    List<WorkDone> findAllByCarId(Integer carId);

    WorkDone save(WorkDone workDone);

    void deleteById(Integer workdoneId);
}
