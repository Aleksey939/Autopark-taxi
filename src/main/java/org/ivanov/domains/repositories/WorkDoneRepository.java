package org.ivanov.domains.repositories;

import org.ivanov.domains.entities.WorkDone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkDoneRepository  extends JpaRepository<WorkDone, Integer> {
}
