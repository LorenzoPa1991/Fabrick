package com.fabrick.demo.dto;

import lombok.Data;

@Data
public class AirportDto {

    private String id;
    private String iata;
    private String name;
    private String country;
    private String state;
    private Double latitude;
    private Double longitude;
    private Double elevation;

}