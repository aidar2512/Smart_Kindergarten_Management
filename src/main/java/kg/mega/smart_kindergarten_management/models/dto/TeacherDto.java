package kg.mega.smart_kindergarten_management.models.dto;

import kg.mega.smart_kindergarten_management.models.enums.TeacherDegree;
import lombok.Data;

@Data
public class TeacherDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String patronymic;
    private TeacherDegree teacherDegree;
    private Boolean active;
}
