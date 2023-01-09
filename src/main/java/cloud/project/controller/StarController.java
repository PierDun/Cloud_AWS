package cloud.project.controller;

import cloud.project.dto.StarDTO;
import cloud.project.model.Star;
import cloud.project.service.StarService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stars")
@AllArgsConstructor
public class StarController {
    private final StarService starService;

    @GetMapping
    public List<Star> getAll () {
        return starService.getStars();
    }

    @GetMapping("/{id}")
    public Star getById (@PathVariable Long id) {
        return starService.getById(id);
    }

    @PostMapping
    public Star createUser (StarDTO dto) {
        return starService.createStar(dto);
    }

    @PutMapping("/{id}")
    public Star updateUser (@PathVariable Long id, StarDTO dto) {
        dto.setId(id);
        return starService.updateStar(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        starService.deleteStar(id);
    }
}
