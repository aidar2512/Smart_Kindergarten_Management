package kg.mega.smart_kindergarten_management.repositories;


import kg.mega.smart_kindergarten_management.models.GroupChildren;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupChildrenRepo extends JpaRepository<GroupChildren, Long> {

    long countByGroup_IdAndEndDateIsNull(Long groupId);

    boolean existsByChild_FirstNameAndChild_LastNameAndEndDateIsNull(String firstName, String lastName);
    boolean existsByGroup_IdAndEndDateIsNull(Long groupId);


}

