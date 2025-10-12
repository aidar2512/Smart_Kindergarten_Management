package kg.mega.smart_kindergarten_management.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import kg.mega.smart_kindergarten_management.models.enums.TeacherDegree;
import lombok.Data;

@Data
public class TeacherCreateDto {
    @NotBlank(message = "Имя обязательно")
    private String firstName;

    @NotBlank(message = "Фамилия обязательна")
    private String lastName;

    private String patronymic;

    @NotNull(message = "Степень обязательна")
    private TeacherDegree teacherDegree;

    @NotNull(message = "Статус обязателен")
    private Boolean active;
}
