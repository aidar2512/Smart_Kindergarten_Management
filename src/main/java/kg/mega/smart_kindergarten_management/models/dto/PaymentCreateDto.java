package kg.mega.smart_kindergarten_management.models.dto;


import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PaymentCreateDto {
    @NotNull
    private Long groupChildrenId;

    @NotNull
    @Positive
    private Integer amount;

    @NotNull
    private LocalDate paymentDate;
}

