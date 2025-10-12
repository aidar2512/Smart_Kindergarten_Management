package kg.mega.smart_kindergarten_management.models.dto;

import lombok.Data;

@Data
public class PreviousMonthDebtDto {
    private Long childId;
    private Integer amountDue;
}

