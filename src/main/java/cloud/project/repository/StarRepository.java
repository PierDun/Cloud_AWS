package cloud.project.repository;

import cloud.project.model.Star;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StarRepository extends CrudRepository<Star, Long> {
    Optional<Star> findByName (String name);
}