package kg.mega.smart_kindergarten_management.models;

import jakarta.persistence.*;
import kg.mega.smart_kindergarten_management.models.enums.TeacherDegree;
import lombok.*;

@Entity
@Table(name = "teachers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
    private String patronymic;

    @Enumerated(EnumType.STRING)
    private TeacherDegree teacherDegree;

    private Boolean active;
}
