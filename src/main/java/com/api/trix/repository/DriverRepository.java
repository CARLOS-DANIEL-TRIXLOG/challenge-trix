package com.api.trix.repository;

import com.api.trix.model.DriverModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DriverRepository extends JpaRepository<DriverModel, Long> {
    @Query(value = "select d from DriverModel d where d.name like %?1%")
    List<DriverModel> findByName(String name);
}


