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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private String patronymic;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TeacherDegree teacherDegree;

    @Column(nullable = false)
    private Boolean active;
}
