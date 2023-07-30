package ie.atu.PassengerAP1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/passenger")
public class PassengerController {
    PassengerService myService;

    //Injects an instance of class for reference when code is running
    public PassengerController(PassengerService myService){
        this.myService = myService;
    }

        @GetMapping
        public List<Passenger> getPassengers(){//Hard coding in values because not connected to database
        return myService.getPassengers();
    }

        @GetMapping("/{passengerID}")
        public Passenger getPassenger(@PathVariable String passengerID) {
        return myService.getMyPassenger(passengerID);
    }
}
