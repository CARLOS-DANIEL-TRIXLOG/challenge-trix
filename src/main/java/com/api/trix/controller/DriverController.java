package com.api.trix.controller;

import com.api.trix.model.DriverModel;
import com.api.trix.repository.DriverRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class DriverController {
    private DriverRepository repository;

    @GetMapping("/driver")
    public List<DriverModel> getAllDrivers() {
        return repository.findAll();
    }

    @GetMapping("/driver/{id}")
    public DriverModel getById(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @GetMapping("/driver/name")
    public List<DriverModel> getByName(@RequestParam(name = "name") String name) {
        return repository.findByName(name);
    }

    @PostMapping("/driver")
    public DriverModel createDriver(@RequestBody DriverModel driver) {
        return repository.save(driver);
    }

    @PutMapping("/driver/{id}")
    public DriverModel updateDriver(@PathVariable Long id, @RequestBody DriverModel driver) {
        var driverToUpdate = repository.findById(id).get();
        driverToUpdate.setName(driver.getName());
        driverToUpdate.setCnh(driver.getCnh());
        return repository.save(driverToUpdate);
    }

    @DeleteMapping("/driver/{id}")
    public DriverModel deleteDriver(@PathVariable Long id) {
        var driver = repository.findById(id).get();
        repository.deleteById(id);
        return driver;
    }

}
