package kg.mega.smart_kindergarten_management.services.impl;


import kg.mega.smart_kindergarten_management.exception.ConflictException;
import kg.mega.smart_kindergarten_management.exception.NotFoundException;
import kg.mega.smart_kindergarten_management.mappers.PaymentMapper;
import kg.mega.smart_kindergarten_management.models.GroupChildren;
import kg.mega.smart_kindergarten_management.models.Payment;
import kg.mega.smart_kindergarten_management.models.dto.PaymentCreateDto;
import kg.mega.smart_kindergarten_management.models.dto.PaymentDto;
import kg.mega.smart_kindergarten_management.models.dto.PreviousMonthDebtDto;
import kg.mega.smart_kindergarten_management.repositories.GroupChildrenRepo;
import kg.mega.smart_kindergarten_management.repositories.PaymentRepo;
import kg.mega.smart_kindergarten_management.services.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepo paymentRepo;
    private final GroupChildrenRepo groupChildrenRepo;
    private final PaymentMapper mapper;

    @Override
    public PaymentDto create(PaymentCreateDto dto) {
        GroupChildren gc = groupChildrenRepo.findById(dto.getGroupChildrenId())
                .orElseThrow(() -> new NotFoundException("Ребенок не найден в группе"));

        if (gc.getEndDate() != null) {
            throw new ConflictException("Ребенок уже отчислен, оплата невозможна");
        }

        if (dto.getAmount() == null || dto.getAmount() <= 0) {
            throw new ConflictException("Сумма платежа должна быть положительной");
        }

        if (dto.getPaymentDate() == null) {
            throw new ConflictException("Дата платежа обязательна");
        }
        if (dto.getPaymentDate().isAfter(LocalDate.now())) {
            throw new ConflictException("Дата платежа не может быть в будущем");
        }

        Payment payment = mapper.toEntity(dto);
        payment.setGroupChildren(gc);

        return mapper.toDto(paymentRepo.save(payment));
    }

    @Override
    public PreviousMonthDebtDto getPreviousMonthDebt(Long childId) {
        GroupChildren gc = groupChildrenRepo.findAll().stream()
                .filter(g -> g.getChild().getId().equals(childId))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Ребенок не найден или не состоит в группе"));

        YearMonth prevMonth = YearMonth.now().minusMonths(1);
        LocalDate start = prevMonth.atDay(1);
        LocalDate end = prevMonth.atEndOfMonth();

        if (gc.getStartDate().isAfter(end) ||
                (gc.getEndDate() != null && gc.getEndDate().isBefore(start))) {
            throw new ConflictException("Ребенок не посещал садик в прошлом месяце");
        }

        List<Payment> payments = paymentRepo.findAllByGroupChildren_IdAndPaymentDateBetween(gc.getId(), start, end);
        int totalPaid = payments.stream().mapToInt(Payment::getAmount).sum();

        int price = gc.getPrice() != null ? gc.getPrice() : gc.getGroup().getPrice();

        PreviousMonthDebtDto result = new PreviousMonthDebtDto();
        result.setChildId(childId);
        result.setAmountDue(Math.max(price - totalPaid, 0));
        return result;
    }
}

