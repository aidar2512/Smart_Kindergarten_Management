package kg.mega.smart_kindergarten_management.models.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EnrollChildDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String patronymic;
    private LocalDate dateOfBirth;
    private Long groupId;
    private Integer price;
}
