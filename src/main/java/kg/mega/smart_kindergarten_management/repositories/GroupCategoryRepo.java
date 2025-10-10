package kg.mega.smart_kindergarten_management.repositories;

import kg.mega.smart_kindergarten_management.models.GroupCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupCategoryRepo extends JpaRepository<GroupCategory, Long> {

    boolean existsByName(String name);

}


