package com.api.trix.component;

import com.api.trix.model.DriverModel;
import com.api.trix.repository.DriverRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ComponentDriver implements CommandLineRunner {
    private DriverRepository driverRepository;

    @Override
    public void run(String... args) throws Exception {
        // Creating drivers to API test
        if (!driverRepository.existsById(1L)) {
            var driver = new DriverModel();
            driver.setId(1L);
            driver.setName("Carlos");
            driver.setCnh("01234567891");
            driverRepository.save(driver);
        }

        if (!driverRepository.existsById(2L)) {
            var driver = new DriverModel();
            driver.setId(2L);
            driver.setName("Daniel");
            driver.setCnh("01234567892");
            driverRepository.save(driver);
        }

        if (!driverRepository.existsById(3L)) {
            var driver = new DriverModel();
            driver.setId(3L);
            driver.setName("Gomes");
            driver.setCnh("01234567893");
            driverRepository.save(driver);
        }

        if (!driverRepository.existsById(4L)) {
            var driver = new DriverModel();
            driver.setId(4L);
            driver.setName("Santana");
            driver.setCnh("01234567894");
            driverRepository.save(driver);
        }


    }
}
