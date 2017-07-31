package ramya.repository;


import ramya.entity.Alerts;
import ramya.entity.Readings;
import ramya.entity.Tires;
import ramya.entity.Vehicle;

import java.util.List;

public interface VehicleRepository {

    List<Vehicle> findAll();
    Vehicle findOne(String vin);
    Vehicle create(Vehicle veh);
    Vehicle update(Vehicle veh);
    List<Readings> findAllReadings();
    Readings findOneReadings(String id);
    Readings createReadings(Readings readings);
    Readings updateReadings(Readings readings);
    Alerts generate(Alerts alert);
    void createTire(Tires tire);
    void createAlert(Alerts alert);
    //List<Alerts> allAlerts();
    //List<Readings> findAll(String vin, String signal);
   // List<Object> getLocation(String vin);
}
