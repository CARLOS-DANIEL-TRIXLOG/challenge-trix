package com.api.trix.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
@Table(name = "tb_vehicle")
public class VehicleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String plate;

    @Column(unique = true, nullable = false)
    private String chassi;

    @Column(unique = true, nullable = false)
    private String renavam;

    private Integer modelYear;

    private Integer manufactureYear;

    private String color;

    private String uf;

    @DateTimeFormat(style = "yyyy-MM-dd")
    private LocalDate acquisitionDate;

    @ManyToOne
    @JoinColumn(name = "id_driver")
    private DriverModel driver;
}
