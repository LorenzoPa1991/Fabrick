package com.fabrick.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "AIRPORTS")
@Entity
public class Airport {

    @Id
    private String id;
    private String iata;
    private String name;
    private String country;
    private String state;
    private Double latitude;
    private Double longitude;
    private Double elevation;

}