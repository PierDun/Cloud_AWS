package cloud.project.repository;

import cloud.project.model.Planet;
import cloud.project.model.Star;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlanetRepository extends CrudRepository<Planet, Long> {
    Optional<Planet> findByName (String name);
    List<Planet> findByStar (Star star);
}