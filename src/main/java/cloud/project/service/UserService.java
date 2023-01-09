package cloud.project.service;

import cloud.project.dto.UserDTO;
import cloud.project.model.Role;
import cloud.project.model.User;
import cloud.project.repository.UserRepository;
import javax.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getUsers () {
        return (List<User>) userRepository.findAll();
    }

    public User getById (Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.valueOf(id)));
    }

    public User getByLogin (String login) {
        return userRepository.findByLogin(login)
                .orElseThrow(() -> new EntityNotFoundException(String.valueOf(login)));
    }

    public User createUser (UserDTO dto) {
        User user = new User();
        user.setLogin(dto.getLogin());
        user.setPassword(dto.getPassword());
        user.setRole(Role.valueOf(dto.getRole()));
        user = userRepository.save(user);
        return user;
    }

    public User updateUser (UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setLogin(dto.getLogin());
        user.setPassword(dto.getPassword());
        user.setRole(Role.valueOf(dto.getRole()));
        user = userRepository.save(user);
        return user;
    }

    public void deleteUser (Long id) {
        User user = getById(id);
        userRepository.delete(user);
    }
}