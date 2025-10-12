package kg.mega.smart_kindergarten_management.models.dto;


import lombok.Data;
import java.time.LocalDate;

@Data
public class PaymentDto {
    private Long id;
    private Long groupChildrenId;
    private Integer amount;
    private LocalDate paymentDate;
}

