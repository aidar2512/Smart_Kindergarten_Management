package kg.mega.smart_kindergarten_management.repositories;

import kg.mega.smart_kindergarten_management.models.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildRepo extends JpaRepository<Child, Long> {

}
