package com.api.trix.component;

import com.api.trix.model.DriverModel;
import com.api.trix.model.VehicleModel;
import com.api.trix.repository.DriverRepository;
import com.api.trix.repository.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@AllArgsConstructor
public class ComponentVehicle implements CommandLineRunner {
    private VehicleRepository vehicleRepository;
    private DriverRepository driverRepository;

    @Override
    public void run(String... args) throws Exception {
        // Creating vehicles to API test
        if (!vehicleRepository.existsById(1L)) {
            var vehicle = new VehicleModel();
            vehicle.setId(1L);
            vehicle.setPlate("ABC1234");
            vehicle.setChassi("9BG116GW04C400001");
            vehicle.setRenavam("123456789");
            vehicle.setModelYear(2018);
            vehicle.setManufactureYear(2018);
            vehicle.setColor("blue");
            vehicle.setUf("CE");
            vehicle.setAcquisitionDate(LocalDate.of(2019,3,23));
            vehicleRepository.save(vehicle);
        }

        if (!vehicleRepository.existsById(2L)) {
            var driver = new DriverModel();
            driver.setId(4L);
            driver.setName("Santana");
            driver.setCnh("01234547894");
            driverRepository.save(driver);

            var vehicle = new VehicleModel();
            vehicle.setId(2L);
            vehicle.setPlate("ABC4321");
            vehicle.setChassi("9BG226GW04C400004");
            vehicle.setRenavam("012345678");
            vehicle.setModelYear(2019);
            vehicle.setManufactureYear(2019);
            vehicle.setColor("red");
            vehicle.setUf("MT");
            vehicle.setAcquisitionDate(LocalDate.of(2020,7,19));
            vehicle.setDriver(driver);
            vehicleRepository.save(vehicle);
        }
    }
}
