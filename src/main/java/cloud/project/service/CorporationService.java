package cloud.project.service;

import cloud.project.dto.CorporationDTO;
import cloud.project.model.Corporation;
import cloud.project.model.Role;
import cloud.project.model.User;
import cloud.project.repository.CorporationRepository;
import javax.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CorporationService {
    private final CorporationRepository corporationRepository;
    private final UserService userService;
    private EmailService emailService;

    public List<Corporation> getCorporations () {
        return (List<Corporation>) corporationRepository.findAll();
    }

    public Corporation getById (Long id) {
        return corporationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.valueOf(id)));
    }

    public Corporation createCorporation (CorporationDTO dto) {
        User owner = new User(
                dto.getOwner().getId(),
                dto.getOwner().getLogin(),
                dto.getOwner().getPassword(),
                Role.valueOf(dto.getOwner().getRole()));

        Corporation corporation = new Corporation();
        corporation.setName(dto.getName());
        corporation.setOwner(owner);
        corporation = corporationRepository.save(corporation);

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("245031@niuitmo.ru");
        simpleMailMessage.setTo(owner.getLogin());
        simpleMailMessage.setSubject("Corporation #" + corporation.getId());
        simpleMailMessage.setText("Your corporation '" + corporation.getName() + "' has been successfully created");
        emailService.sendMessage(simpleMailMessage);

        return corporation;
    }

    public Corporation updateCorporation (CorporationDTO dto) {
        User owner = userService.updateUser(dto.getOwner());
        Corporation corporation = new Corporation(
                dto.getId(),
                dto.getName(),
                owner);
        corporation = corporationRepository.save(corporation);
        return corporation;
    }

    public void deleteCorporation (Long id) {
        Corporation corporation = getById(id);
        corporationRepository.delete(corporation);
    }
}