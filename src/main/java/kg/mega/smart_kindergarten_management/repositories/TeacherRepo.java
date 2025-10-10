package kg.mega.smart_kindergarten_management.repositories;

import kg.mega.smart_kindergarten_management.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepo extends JpaRepository<Teacher, Long> {
    boolean existsByFirstNameIgnoreCaseAndLastNameIgnoreCase(String firstName, String lastName);
}
