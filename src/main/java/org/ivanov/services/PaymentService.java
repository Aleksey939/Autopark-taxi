package org.ivanov.services;

import org.ivanov.domains.entities.Car;
import org.ivanov.domains.entities.Payment;

import java.util.List;
import java.util.Optional;

public interface PaymentService {
    List<Payment> findAll();
    Optional<Payment> findById(Integer paymentId);

    Payment save(Payment payment);

    void deleteById(Integer paymentId);
}
