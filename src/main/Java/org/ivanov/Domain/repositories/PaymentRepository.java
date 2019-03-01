package org.ivanov.Domain.repositories;

import org.ivanov.Domain.entity.Coming;
import org.ivanov.Domain.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository  extends JpaRepository<Payment, Integer> {
}
