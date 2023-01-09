package cloud.project.service;

import cloud.project.dto.StarDTO;
import cloud.project.model.Star;
import cloud.project.repository.StarRepository;
import javax.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StarService {
    private final StarRepository starRepository;

    public List<Star> getStars () {
        return (List<Star>) starRepository.findAll();
    }

    public Star getById (Long id) {
        return starRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.valueOf(id)));
    }

    public Star createStar (StarDTO dto) {
        Star star = new Star();
        star.setName(dto.getName());
        star = starRepository.save(star);
        return star;
    }

    public Star updateStar (StarDTO dto) {
        Star star = new Star(
                dto.getId(),
                dto.getName());
        star = starRepository.save(star);
        return star;
    }

    public void deleteStar (Long id) {
        Star star = getById(id);
        starRepository.delete(star);
    }
}