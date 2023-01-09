package cloud.project.repository;

import cloud.project.model.Order;
import cloud.project.model.Planet;
import cloud.project.model.User;
import cloud.project.model.Weapon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
    List<Order> findByCustomer (User customer);

    List<Order> findByPlanet (Planet planet);

    List<Order> findByWeapon (Weapon weapon);
}