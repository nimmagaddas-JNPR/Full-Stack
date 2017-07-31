package ramya.repository;


import org.springframework.stereotype.Repository;
import ramya.entity.Alerts;
import ramya.entity.Readings;
import ramya.entity.Tires;
import ramya.entity.Vehicle;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class VehicleRepositoryImpl implements VehicleRepository {

    @PersistenceContext
    private EntityManager entityManager;


    public List<Vehicle> findAll() {

        TypedQuery<Vehicle> query = entityManager.createNamedQuery("Vehicle.findAll", Vehicle.class);
        return query.getResultList();

    }


    public Vehicle findOne(String vin) {
        return entityManager.find(Vehicle.class, vin);
    }


    public Vehicle create(Vehicle veh) {
        entityManager.persist(veh);
        return veh;
    }

    public Vehicle update(Vehicle veh) {

        entityManager.merge(veh);
        return veh;
    }

    // Readings
    public List<Readings> findAllReadings()
    {
        TypedQuery<Readings> query = entityManager.createNamedQuery("Readings.findAllReading", Readings.class);
        return query.getResultList();
    }

    public Readings findOneReadings(String id) {
        return entityManager.find(Readings.class, id);

    }

    public Readings createReadings(Readings reads) {
       // generate(readings);
        entityManager.persist(reads);
        return reads;
    }

    public Readings updateReadings(Readings reads) {
        return entityManager.merge(reads);
    }


    public Alerts generate(Alerts alert) {
        entityManager.persist(alert);
        return alert;
    }

    public void createTire(Tires tire) {
        entityManager.persist(tire);
    }

    public void createAlert(Alerts alert) {
        entityManager.persist(alert);
    }

    //

}
