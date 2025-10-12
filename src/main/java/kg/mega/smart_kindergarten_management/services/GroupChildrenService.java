package kg.mega.smart_kindergarten_management.services;

import kg.mega.smart_kindergarten_management.models.dto.EnrollChildCreateDto;
import kg.mega.smart_kindergarten_management.models.dto.EnrollChildDto;
import kg.mega.smart_kindergarten_management.models.dto.WithdrawChildDto;

public interface GroupChildrenService {
    EnrollChildDto enroll(EnrollChildCreateDto dto);
    EnrollChildDto withdraw(Long id, WithdrawChildDto dto);
}

