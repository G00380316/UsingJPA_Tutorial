package ie.atu.PassengerAP1;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class PassengerService {

    private final PassengerRepo passengerRepo;

    public List<Passenger> getPassengers()
    {
        return passengerRepo.findAll();
    }

    public Passenger getMyPassenger(String passengerID) {
        Passenger myPassenger = new Passenger("Mr","Enoch","123",123,20);
        return myPassenger;
    }
}
