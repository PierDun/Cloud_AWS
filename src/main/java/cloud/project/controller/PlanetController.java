package cloud.project.controller;

import cloud.project.dto.PlanetDTO;
import cloud.project.model.Planet;
import cloud.project.service.PlanetService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/planets")
@AllArgsConstructor
public class PlanetController {
    private final PlanetService planetService;

    @GetMapping
    public List<Planet> getAll () {
        return planetService.getPlanets();
    }

    @GetMapping("/{id}")
    public Planet getById (@PathVariable Long id) {
        return planetService.getById(id);
    }

    @PostMapping
    public Planet createPlanet (@RequestBody PlanetDTO dto) {
        return planetService.createPlanet(dto);
    }

    @PutMapping("/{id}")
    public Planet updatePlanet (@PathVariable Long id, @RequestBody PlanetDTO dto) {
        dto.setId(id);
        return planetService.updatePlanet(dto);
    }

    @DeleteMapping("/{id}")
    public void deletePlanet (@PathVariable Long id) {
        planetService.deletePlanet(id);
    }
}
