package kg.mega.smart_kindergarten_management.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EnrollChildCreateDto {
    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    private String patronymic;

    @NotNull
    private LocalDate dateOfBirth;

    @NotNull
    private Long groupId;

    private Integer price;
}
