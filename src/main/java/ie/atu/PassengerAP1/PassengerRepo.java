package ie.atu.PassengerAP1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PassengerRepo extends JpaRepository<Passenger, Long>{
   public Passenger findPassengerByName(String name);
   @Query("SELECT p FROM Passenger p WHERE p.age > ?1 and p.age < ?2")
   public List<Passenger> findPassengerByAge(int age,int age2);
}
