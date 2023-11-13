package g58008.associations.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Car {
    @Id
    private Long id;

    @OneToOne
    private ParkingSpot parkingSpot;
}
