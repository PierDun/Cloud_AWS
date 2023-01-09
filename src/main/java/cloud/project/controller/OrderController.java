package cloud.project.controller;

import cloud.project.dto.OrderDTO;
import cloud.project.model.Order;
import cloud.project.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@AllArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public List<Order> getAll () {
        return orderService.getOrders();
    }

    @GetMapping("/{id}")
    public Order getById (@PathVariable Long id) {
        return orderService.getById(id);
    }

    @PostMapping
    public Order createOrder (@RequestBody OrderDTO dto) {
        return orderService.createOrder(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder (@PathVariable Long id) {
        orderService.deleteOrder(id);
    }
}