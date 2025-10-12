package kg.mega.smart_kindergarten_management.services;

import kg.mega.smart_kindergarten_management.models.dto.PaymentCreateDto;
import kg.mega.smart_kindergarten_management.models.dto.PaymentDto;
import kg.mega.smart_kindergarten_management.models.dto.PreviousMonthDebtDto;

public interface PaymentService {
    PaymentDto create(PaymentCreateDto dto);
    PreviousMonthDebtDto getPreviousMonthDebt(Long childId);
}

