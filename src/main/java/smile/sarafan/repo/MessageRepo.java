package smile.sarafan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import smile.sarafan.domain.Message;
@Repository
public interface MessageRepo extends JpaRepository<Message, Long> {
}
