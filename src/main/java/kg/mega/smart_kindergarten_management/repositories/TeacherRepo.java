package kg.mega.smart_kindergarten_management.repositories;

import kg.mega.smart_kindergarten_management.models.Teacher;
import kg.mega.smart_kindergarten_management.models.enums.TeacherDegree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Long> {

    boolean existsByFirstNameAndLastNameAndPatronymicAndTeacherDegree(
            String firstName, String lastName, String patronymic, TeacherDegree teacherDegree);
}
