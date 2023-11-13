package g58008.associations.service;

import g58008.associations.database.CarRepository;
import g58008.associations.database.ParkingSpotRepository;
import g58008.associations.model.Car;
import g58008.associations.model.ParkingSpot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Crée une association entre Car et ParkingSpot en uni-directional et One To One.
 * WARNING : Aucune vérification, aucun display, que des urls.
 * HELP :
 * /parking/create -> create and store a parking spot in the database
 * /car/create -> create and store a car in the database
 */
@Service
public class OtoUnidirectional {
    @Autowired
    private CarRepository carRepository;

    @Autowired
    private ParkingSpotRepository parkingSpotRepository;

    public void addCar(Long id) {
        ParkingSpot parkingSpot = parkingSpotRepository.findById(1L).get();
        carRepository.save(new Car(id, parkingSpot));
    }

    public void addParking(Long id) {
        parkingSpotRepository.save(new ParkingSpot(id));
    }
}
