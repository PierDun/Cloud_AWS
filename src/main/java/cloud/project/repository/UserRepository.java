package cloud.project.repository;

import cloud.project.model.Role;
import cloud.project.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByLogin (String name);

    Optional<User> findByPassword (String password);

    Optional<User> findByRole (Role role);

    Optional<User> findByLoginAndPassword (String name, String password);
}