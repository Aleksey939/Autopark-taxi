package org.ivanov.domain.repositories;

import org.ivanov.domain.entity.WorkDone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkDoneRepository  extends JpaRepository<WorkDone, Integer> {
}
