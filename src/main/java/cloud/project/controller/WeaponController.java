package cloud.project.controller;

import cloud.project.model.Weapon;
import cloud.project.service.WeaponService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/weapons")
@AllArgsConstructor
public class WeaponController {
    private final WeaponService weaponService;

    @GetMapping
    public List<Weapon> getAll () {
        return weaponService.getWeapons();
    }

    @GetMapping("/{id}")
    public Weapon getById (@PathVariable Long id) {
        return weaponService.getById(id);
    }
}