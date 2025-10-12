package kg.mega.smart_kindergarten_management.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kg.mega.smart_kindergarten_management.models.dto.PaymentCreateDto;
import kg.mega.smart_kindergarten_management.models.dto.PaymentDto;
import kg.mega.smart_kindergarten_management.models.dto.PreviousMonthDebtDto;
import kg.mega.smart_kindergarten_management.services.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
@Tag(name = "Payments Controller", description = "Оплата за садик")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService service;

    @PostMapping
    @Operation(summary = "Создание платежа")
    public ResponseEntity<PaymentDto> addPayment(@RequestBody PaymentCreateDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/previous-month/{childId}")
    @Operation(summary = "Получение задолженности за прошлый месяц")
    public ResponseEntity<PreviousMonthDebtDto> getDebt(@PathVariable Long childId) {
        return ResponseEntity.ok(service.getPreviousMonthDebt(childId));
    }
}

