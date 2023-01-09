package cloud.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanetDTO {
    private Long id;
    private String name;
    private StarDTO star;
}