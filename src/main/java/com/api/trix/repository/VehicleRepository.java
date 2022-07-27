package com.api.trix.repository;

import com.api.trix.model.VehicleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehicleRepository extends JpaRepository<VehicleModel, Long> {
    @Query(value = "select v from VehicleModel v where v.plate like %?1%")
    List<VehicleModel> findByPlate(String plate);
}
