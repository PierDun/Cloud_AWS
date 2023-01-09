package cloud.project.controller;

import cloud.project.dto.CorporationDTO;
import cloud.project.model.Corporation;
import cloud.project.service.CorporationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/corporations")
@AllArgsConstructor
public class CorporationController {
    private final CorporationService corporationService;

    @GetMapping
    public List<Corporation> getAll () {
        return corporationService.getCorporations();
    }

    @GetMapping("/{id}")
    public Corporation getById (@PathVariable Long id) {
        return corporationService.getById(id);
    }

    @PostMapping
    public Corporation createCorporation (@RequestBody CorporationDTO dto) {
        return corporationService.createCorporation(dto);
    }

    @PutMapping("/{id}")
    public Corporation updateCorporation (@PathVariable Long id, @RequestBody CorporationDTO dto) {
        dto.setId(id);
        return corporationService.updateCorporation(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteCorporation (@PathVariable Long id) {
        corporationService.deleteCorporation(id);
    }
}