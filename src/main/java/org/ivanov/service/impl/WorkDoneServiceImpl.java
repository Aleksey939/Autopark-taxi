package org.ivanov.service.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.ivanov.domain.entity.WorkDone;
import org.ivanov.domain.repositories.WorkDoneRepository;
import org.ivanov.service.WorkDoneService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WorkDoneServiceImpl implements WorkDoneService {
    final WorkDoneRepository workDoneRepository;

    @Override
    public Optional<WorkDone> findById(@NonNull Integer workdoneId) {
        return workDoneRepository.findById(workdoneId);
    }

    @Override
    public List<WorkDone> findAll() {
        return workDoneRepository.findAll();
    }

    @Override
    public List<WorkDone> findAllByCarId(@NonNull Integer carId) {
        return workDoneRepository.findAllByCarId(carId);
    }

    @Override
    public WorkDone save(@NonNull WorkDone workDone) {
        return workDoneRepository.save(workDone);
    }

    @Override
    public void deleteById(@NonNull Integer workdoneId) {
        workDoneRepository.deleteById(workdoneId);
    }
}
