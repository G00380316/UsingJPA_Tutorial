package ie.atu.PassengerAP1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/passenger")
public class PassengerController {
    private final PassengerService myService;

    //Injects an instance of class for reference when code is running
    @Autowired
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
    //http://localhost:8080/api/passenger/age?age_start=16&age_end=60
    @GetMapping("/age")
    public List<Passenger> getPassengersByAge(@RequestParam(name = "age_start") int age1,@RequestParam(name = "age_end") int age2){
        return myService.findPassengerByAgeRange(age1, age2);
    }
}
