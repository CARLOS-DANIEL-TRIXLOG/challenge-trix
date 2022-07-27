package com.api.trix.controller;

import com.api.trix.model.VehicleModel;
import com.api.trix.repository.DriverRepository;
import com.api.trix.repository.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class VehicleController {
    private VehicleRepository repository;
    private DriverRepository driverRepository;

    @GetMapping("/vehicle")
    public List<VehicleModel> getAllVehicles(){
        return repository.findAll();
    }

    @GetMapping("/vehicle/{id}")
    public VehicleModel getById(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @GetMapping("/vehicle/plate")
    public List<VehicleModel> getByPlate(@RequestParam(name = "plate") String plate) {
        return repository.findByPlate(plate);
    }

    @PostMapping("/vehicle")
    public VehicleModel createVehicle(@RequestBody VehicleModel vehicle) {
        return repository.save(vehicle);
    }

    @PutMapping("/vehicle/{id}")
    public VehicleModel updateVehicle(@PathVariable Long id, @RequestBody VehicleModel vehicle) {
        var vehicleToUpdate = repository.findById(id).get();
        Long id_driver = vehicle.getDriver().getId();
        vehicleToUpdate.setPlate(vehicle.getPlate());
        vehicleToUpdate.setChassi(vehicle.getChassi());
        vehicleToUpdate.setRenavam(vehicle.getRenavam());
        vehicleToUpdate.setModelYear(vehicle.getModelYear());
        vehicleToUpdate.setManufactureYear(vehicle.getManufactureYear());
        vehicleToUpdate.setColor(vehicle.getColor());
        vehicleToUpdate.setUf(vehicle.getUf());
        vehicleToUpdate.setAcquisitionDate(vehicle.getAcquisitionDate());
        vehicleToUpdate.setDriver(
                driverRepository
                        .findById(id_driver)
                        .get()
        );

        return repository.save(vehicleToUpdate);
    }

    @DeleteMapping("/vehicle/{id}")
    public VehicleModel deleteVehicle(@PathVariable Long id) {
        var vehicle = repository.findById(id).get();
        repository.deleteById(id);
        return vehicle;
    }
}
