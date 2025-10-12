package kg.mega.smart_kindergarten_management.repositories;

import kg.mega.smart_kindergarten_management.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PaymentRepo extends JpaRepository<Payment, Long> {
    List<Payment> findAllByGroupChildren_IdAndPaymentDateBetween(Long groupChildrenId, LocalDate start, LocalDate end);
}

