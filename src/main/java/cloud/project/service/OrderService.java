package cloud.project.service;

import cloud.project.dto.OrderDTO;
import cloud.project.model.*;
import cloud.project.repository.OrderRepository;
import cloud.project.repository.WeaponRepository;
import javax.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final WeaponRepository weaponRepository;
    private EmailService emailService;

    public List<Order> getOrders () {
        return (List<Order>) orderRepository.findAll();
    }

    public Order getById (Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.valueOf(id)));
    }

    public Order createOrder (OrderDTO dto) {
        User customer = new User(
                dto.getCustomer().getId(),
                dto.getCustomer().getLogin(),
                dto.getCustomer().getPassword(),
                Role.valueOf(dto.getCustomer().getRole())
        );

        Weapon weapon = new Weapon(
                dto.getWeapon().getId(),
                new Corporation(
                        dto.getWeapon().getCreator().getId(),
                        dto.getWeapon().getCreator().getName(),
                        new User(
                                dto.getWeapon().getCreator().getOwner().getId(),
                                dto.getWeapon().getCreator().getOwner().getLogin(),
                                dto.getWeapon().getCreator().getOwner().getPassword(),
                                Role.valueOf(dto.getWeapon().getCreator().getOwner().getRole())
                        )
                )
        );
        weapon = weaponRepository.save(weapon);

        Planet planet = new Planet(
                dto.getPlanet().getId(),
                dto.getPlanet().getName(),
                new Star(
                        dto.getPlanet().getStar().getId(),
                        dto.getPlanet().getStar().getName()
                )
        );

        Order order = new Order();
        order.setCustomer(customer);
        order.setDate(LocalDateTime.now());
        order.setWeapon(weapon);
        order.setPlanet(planet);
        order = orderRepository.save(order);

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("245031@niuitmo.ru");
        simpleMailMessage.setTo(customer.getLogin());
        simpleMailMessage.setSubject("Order #" + order.getId());
        simpleMailMessage.setText("Your order #" + order.getId() + " has been successfully created");
        emailService.sendMessage(simpleMailMessage);

        simpleMailMessage.setFrom("245031@niuitmo.ru");
        simpleMailMessage.setTo(weapon.getCreator().getOwner().getLogin());
        simpleMailMessage.setSubject("Order by " + customer.getLogin());
        simpleMailMessage.setText("For your company '" + weapon.getCreator().getName() + "' has been successfully created order by user " + customer.getLogin());
        emailService.sendMessage(simpleMailMessage);

        return order;
    }

    public Order updateOrder (OrderDTO dto) {
        User customer = new User(
                dto.getCustomer().getId(),
                dto.getCustomer().getLogin(),
                dto.getCustomer().getPassword(),
                Role.valueOf(dto.getCustomer().getRole())
        );

        Weapon weapon = new Weapon(
                dto.getWeapon().getId(),
                new Corporation(
                        dto.getWeapon().getCreator().getId(),
                        dto.getWeapon().getCreator().getName(),
                        new User(
                                dto.getWeapon().getCreator().getOwner().getId(),
                                dto.getWeapon().getCreator().getOwner().getLogin(),
                                dto.getWeapon().getCreator().getOwner().getPassword(),
                                Role.valueOf(dto.getWeapon().getCreator().getOwner().getRole())
                        )
                )
        );

        Planet planet = new Planet(
                dto.getPlanet().getId(),
                dto.getPlanet().getName(),
                new Star(
                        dto.getPlanet().getStar().getId(),
                        dto.getPlanet().getStar().getName()
                )
        );

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy - HH:mm:ss z");

        Order order = new Order(
                dto.getId(),
                customer,
                LocalDateTime.parse(dto.getDate(), formatter),
                weapon,
                planet
        );
        order = orderRepository.save(order);
        return order;
    }

    public void deleteOrder (Long id) {
        Order order = getById(id);
        orderRepository.delete(order);
    }
}