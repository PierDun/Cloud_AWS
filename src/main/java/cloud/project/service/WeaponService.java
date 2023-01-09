package cloud.project.service;

import cloud.project.model.Weapon;
import cloud.project.repository.WeaponRepository;
import javax.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class WeaponService {
    private final WeaponRepository weaponRepository;

    public List<Weapon> getWeapons () {
        return (List<Weapon>) weaponRepository.findAll();
    }

    public Weapon getById (Long id) {
        return weaponRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.valueOf(id)));
    }
}
