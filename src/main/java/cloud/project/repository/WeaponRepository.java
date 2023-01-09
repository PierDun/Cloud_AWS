package cloud.project.repository;

import cloud.project.model.Corporation;
import cloud.project.model.Weapon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeaponRepository extends CrudRepository<Weapon, Long> {
    List<Weapon> findByCreator (Corporation corp);
}