package ramya.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ramya.entity.Alerts;
import ramya.entity.Readings;
import ramya.entity.Vehicle;
import ramya.exception.BadRequestException;
import ramya.exception.ResourceNotFoundException;
import ramya.repository.VehicleRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class VehicleServiceImpl implements VehicleService{


    @Autowired
VehicleRepository repository;


    //Vehicles
    @Transactional
    public List<Vehicle> findAll() {return repository.findAll();}

    @Transactional
    public Vehicle findOne(String vin) {
        Vehicle existing = repository.findOne(vin);
        if(existing == null)
        {
            //exception handling
           throw new ResourceNotFoundException("Employee with id" +vin+ "doesn't exists.");
        }
        return existing;
    }

    @Transactional
    public Vehicle create(Vehicle veh) {
        Vehicle existing = repository.findOne(veh.getVin());
        if (existing != null) {
            repository.update(veh);
        } else {
            repository.create(veh);

        }
        return veh;
    }

    @Transactional
    public Vehicle update(String vin, Vehicle veh) {
        Vehicle existing = repository.findOne(vin);
        if(existing==null){
            //exception handing 404 error
            //throw new ResourceNotFoundException("Employee with id" +vin+ "doesn't exists.");
        }
        return repository.update(veh);
    }

    //Readings

    @Transactional
    public List<Readings> findAllReadings() {return  repository.findAllReadings();}


    @Transactional
    public Readings findOneReadings(String id) {
        Readings existing = repository.findOneReadings(id);
        if (existing == null) {
            throw new ResourceNotFoundException("Vehicle Reading with id " + id + " doesn't exist.");
        }
        return existing;
    }

    @Transactional
    public Readings createReadings(Readings read) {
        if (read != null) {
            System.out.println(read);
            Vehicle existing = repository.findOne(read.getVin());
            if (existing == null) {
                throw new BadRequestException("Vehicle with vin " + read.getVin() + " doesn't exists.");
            }
            read.setVehicle(existing);

            Alerts alert = isAlertCreated(read);
            if(alert != null) {
                repository.createAlert(alert);
                read.setAlert(alert);
            }

            repository.createTire(read.getTires());
            repository.createReadings(read);
        }
        return read;
    }

    private Alerts isAlertCreated(Readings read) {
        Alerts alert = new Alerts(read.getTimestamp());
        boolean flag = false;
        if(read.getEngineRpm() > read.getVehicle().getReadLineRpm()) {
            alert.setPriority("HIGH");
            alert.setDescription("Engine RPM going over ReadLine RPM");
            flag = true;
        } else if(read.getFuelVolume() < (.10 * read.getVehicle().getMaxFuelVolume())) {
            alert.setPriority("MEDIUM");
            alert.setDescription("Fuel is too less");
            flag = true;
        } else if(read.getTires().getFrontLeft() < 32 || read.getTires().getFrontLeft() > 36 ||
                read.getTires().getFrontRight() < 32 || read.getTires().getFrontRight() > 36 ||
                read.getTires().getRearLeft() < 32 || read.getTires().getRearLeft() > 36 ||
                read.getTires().getRearRight() < 32 || read.getTires().getRearRight() > 36) {
            alert.setPriority("LOW");
            alert.setDescription("Tire Pressure is LOW or HIGH");
            flag = true;
        } else if(read.isEngineCoolantLow() || read.isCheckEngineLightOn()) {
            alert.setPriority("LOW");
            if(read.isEngineCoolantLow()) alert.setDescription("Engine Coolant is LOW");
            else if(read.isCheckEngineLightOn()) alert.setDescription("Engine Light ON");
            flag = true;
        }
        if(!flag) alert = null;
        return alert;
    }


    @Transactional
    public Readings updateReadings(String id, Readings reads) {
        Readings existing = repository.findOneReadings(id);
        if (existing == null) {
            throw new ResourceNotFoundException("Vehicle Readings with vin " + id + " doesn't exist.");
        }
        return repository.updateReadings(reads);
    }

    @Transactional
    public Alerts generate(Alerts alert) {
        return repository.generate(alert);
    }

}

