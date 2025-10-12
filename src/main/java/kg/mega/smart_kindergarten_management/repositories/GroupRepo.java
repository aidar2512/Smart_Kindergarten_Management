package kg.mega.smart_kindergarten_management.repositories;

import kg.mega.smart_kindergarten_management.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepo extends JpaRepository<Group, Long> {

    boolean existsByName(String name);
    boolean existsByGroupCategory_Id(Long groupCategoryId);
    boolean existsByTeacher_Id(Long teacherId);
    boolean existsByNanny_Id(Long nannyId);
}
