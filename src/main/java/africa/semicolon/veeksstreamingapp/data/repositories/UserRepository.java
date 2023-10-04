package africa.semicolon.veeksstreamingapp.data.repositories;

import africa.semicolon.veeksstreamingapp.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
