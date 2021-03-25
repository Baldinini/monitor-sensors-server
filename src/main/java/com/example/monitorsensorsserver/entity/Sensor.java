package com.example.monitorsensorsserver.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "sensors")
@Data
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private String model;
    @ManyToOne
    private Type type;
    @ManyToOne
    private Unit unit;
    private String location;
    private String description;
    private Integer rangeFrom;
    private Integer rangeTo;
}
