package ie.atu.PassengerAP1;

import org.springframework.data.jpa.repository.JpaRepository;
public interface PassengerRepo extends JpaRepository<Passenger, Long>{
   public Passenger findPassengerByName(String name);
}
