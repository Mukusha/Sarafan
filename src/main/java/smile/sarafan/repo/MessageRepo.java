package smile.sarafan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import smile.sarafan.domain.Message;

public interface MessageRepo extends JpaRepository<Message, Long> {
}
