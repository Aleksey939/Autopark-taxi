package org.ivanov.domain.repositories;

import org.ivanov.domain.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository  extends JpaRepository<Payment, Integer> {
}
