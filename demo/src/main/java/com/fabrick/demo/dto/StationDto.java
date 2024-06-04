package com.fabrick.demo.dto;

import lombok.Data;

@Data
public class StationDto {

    private String id;
    private String name;
    private String country;
    private String state;
    private Double latitude;
    private Double longitude;
    private Double elevation;

}