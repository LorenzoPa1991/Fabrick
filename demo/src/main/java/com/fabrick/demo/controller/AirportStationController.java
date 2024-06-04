package com.fabrick.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fabrick.demo.dto.AirportDto;
import com.fabrick.demo.dto.StationDto;
import com.fabrick.demo.service.AirportService;
import com.fabrick.demo.service.StationService;

@RequestMapping(value = "/api/fabrick/v1.0")
@Controller
public class AirportStationController {

    @Autowired
    private AirportService airportService;

    @Autowired
    private StationService stationService;

    @GetMapping(value = "/airports/{airportId}")
    public ResponseEntity<List<AirportDto>> getAirports(@PathVariable String airportId,
                                                        @RequestParam(value = "closestBy", defaultValue = "0.0") double closestBy) {
        return ResponseEntity.ok(airportService.getClosestAirport(airportId, closestBy));
    }

    @GetMapping(value = "/stations/{stationId}")
    public ResponseEntity<List<StationDto>> getStations(@PathVariable String stationId,
                                                        @RequestParam(value = "closestBy", defaultValue = "0.0") double closestBy) {
        return ResponseEntity.ok(stationService.getClosestStation(stationId, closestBy));
    }

}