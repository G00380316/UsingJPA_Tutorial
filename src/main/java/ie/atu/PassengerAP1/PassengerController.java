package ie.atu.PassengerAP1;

import org.springframework.web.bind.annotation.*;

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

    //Save Operation
    @PostMapping("")
    public void savePassenger(@RequestBody Passenger passenger) {
       myService.savePassenger(passenger);
    }

    @GetMapping("/name/{name}")
    public Passenger getPassengerName(@PathVariable("name") String name){
        return myService.findPassengerByName(name);
    }

    @GetMapping("/delete/{count}")
    public void deletePassenger(@PathVariable("count") Long count){
         myService.deletePassenger(count);
    }
}
