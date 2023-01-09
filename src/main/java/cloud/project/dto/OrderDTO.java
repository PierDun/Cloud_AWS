package cloud.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Long id;
    private UserDTO customer;
    private String date;
    private WeaponDTO weapon;
    private PlanetDTO planet;
}