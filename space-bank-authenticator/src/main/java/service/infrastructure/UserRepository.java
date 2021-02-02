package service.infrastructure;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends EntityRepository {
    public Optional<User> findByEmailAndPassword(String email, String password);
}
