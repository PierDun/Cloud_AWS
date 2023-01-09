package cloud.project.service;

import cloud.project.dto.PlanetDTO;
import cloud.project.model.Planet;
import cloud.project.model.Star;
import cloud.project.repository.PlanetRepository;
import javax.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlanetService {
    private final PlanetRepository planetRepository;

    public List<Planet> getPlanets () {
        return (List<Planet>) planetRepository.findAll();
    }

    public Planet getById (Long id) {
        return planetRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.valueOf(id)));
    }

    public Planet createPlanet (PlanetDTO dto) {
        Planet planet = new Planet();
        Star star = new Star(dto.getStar().getId(), dto.getStar().getName());

        planet.setName(dto.getName());
        planet.setStar(star);

        planet = planetRepository.save(planet);
        return planet;
    }

    public Planet updatePlanet (PlanetDTO dto) {
        Star star = new Star(dto.getStar().getId(), dto.getStar().getName());

        Planet planet = new Planet(dto.getId(), dto.getName(), star);
        planet = planetRepository.save(planet);
        return planet;
    }

    public void deletePlanet (Long id) {
        Planet planet = getById(id);
        planetRepository.delete(planet);
    }
}