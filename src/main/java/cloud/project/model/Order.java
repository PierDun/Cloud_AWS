package cloud.project.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "booking")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer")
    private User customer;

    @Column(name = "date")
    private LocalDateTime date;

    @OneToOne
    @JoinColumn(name = "weapon")
    private Weapon weapon;

    @ManyToOne
    @JoinColumn(name = "planet")
    private Planet planet;
}