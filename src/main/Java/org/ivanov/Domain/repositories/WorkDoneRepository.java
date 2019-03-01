package org.ivanov.Domain.repositories;

import org.ivanov.Domain.entity.WorkDone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkDoneRepository  extends JpaRepository<WorkDone, Integer> {
}
