package cloud.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CorporationDTO {
    private Long id;
    private String name;
    private UserDTO owner;
}