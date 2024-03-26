package smile.sarafan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import smile.sarafan.domain.User;
@Repository
public interface UserRepo extends JpaRepository<User, String> {
    User getUserById(String id);

}