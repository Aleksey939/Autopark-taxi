package org.ivanov.services;

import org.ivanov.domains.entities.Coming;

public interface ComingService {
    Coming create(Coming coming, int carId);

    Coming edit(Coming coming, Integer carId);
}
