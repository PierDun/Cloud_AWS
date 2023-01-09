package cloud.project.repository;

import cloud.project.model.Corporation;
import cloud.project.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CorporationRepository extends CrudRepository<Corporation, Long> {
    Optional<Corporation> findByName (String name);
    List<Corporation> findByOwner (User owner);
}