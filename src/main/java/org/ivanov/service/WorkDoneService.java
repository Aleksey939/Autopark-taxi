package org.ivanov.service;

<<<<<<< Updated upstream
import org.ivanov.domain.entity.WorkDone;
=======
import org.ivanov.domains.entities.WorkDone;
>>>>>>> Stashed changes

import java.util.List;
import java.util.Optional;

public interface WorkDoneService {
    List<WorkDone> findAll();
    Optional<WorkDone> findById(Integer workdoneId);
    List<WorkDone> findAllByCarId(Integer carId);

    WorkDone save(WorkDone workDone);

    void deleteById(Integer workdoneId);
}
