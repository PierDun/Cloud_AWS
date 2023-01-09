package cloud.project.controller;

import cloud.project.dto.UserDTO;
import cloud.project.model.User;
import cloud.project.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<User> getAll () {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public User getById (@PathVariable Long id) {
        return userService.getById(id);
    }

    @PostMapping
    public User createUser (@RequestBody UserDTO dto) {
        return userService.createUser(dto);
    }

    @PutMapping("/{id}")
    public User updateUser (@PathVariable Long id, @RequestBody UserDTO dto) {
        dto.setId(id);
        return userService.updateUser(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}