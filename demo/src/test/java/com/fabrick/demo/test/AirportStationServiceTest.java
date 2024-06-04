package com.fabrick.demo.test;


import com.fabrick.demo.mapper.AirportMapper;
import com.fabrick.demo.mapper.StationMapper;
import com.fabrick.demo.dto.AirportDto;
import com.fabrick.demo.dto.StationDto;
import com.fabrick.demo.entity.Airport;
import com.fabrick.demo.entity.Station;
import com.fabrick.demo.repository.AirportRepository;
import com.fabrick.demo.repository.StationRepository;
import com.fabrick.demo.service.AirportService;
import com.fabrick.demo.service.StationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class AirportStationServiceTest {

    @InjectMocks
    private AirportService airportService;

    @Mock
    private AirportRepository airportRepository;

    @Mock
    private AirportMapper airportMapper;

    @InjectMocks
    private StationService stationService;

    @Mock
    private StationRepository stationRepository;

    @Mock
    private StationMapper stationMapper;

    @BeforeEach
    public void setup() {
        Mockito.reset(airportRepository,airportMapper);
    }

    @Test
    @Order(1)
    void testGivenAirportIdAndClosestByWhenGetClosestAirportThenReturnListOfAirports() {

        //given
        final AirportDto airportDto = new AirportDto();
        final Airport airport = new Airport();
        airport.setId("LIRF");
        airport.setCountry("IT");
        airportDto.setId("LIRF");
        airportDto.setCountry("IT");
        airportDto.setLatitude(0.0);
        airportDto.setLongitude(0.0);
        airportDto.setElevation(0.0);
        final List<AirportDto> expectedResult = List.of(airportDto);

        Mockito.when(airportRepository.findById(airportDto.getId())).thenReturn(Optional.of(airport));
        Mockito.when(airportMapper.entityToDto(airport)).thenReturn(airportDto);


        //when
        final List<AirportDto> actualResult = airportService.getClosestAirport("LIRF", 0.0);

        //then
        Assertions.assertEquals(expectedResult,actualResult,"Airports returned !!");
    }

    @Test
    @Order(1)
    void testGivenStationIdAndClosestByWhenGetClosestStationThenReturnListOfStations() {

        //given
        final StationDto stationDto = new StationDto();
        final Station station = new Station();
        station.setId("LIRF");
        station.setCountry("IT");
        stationDto.setId("LIRF");
        stationDto.setCountry("IT");
        stationDto.setLatitude(0.0);
        stationDto.setLongitude(0.0);
        stationDto.setElevation(0.0);
        final List<StationDto> expectedResult = List.of(stationDto);

        Mockito.when(stationRepository.findById(stationDto.getId())).thenReturn(Optional.of(station));
        Mockito.when(stationMapper.entityToDto(station)).thenReturn(stationDto);


        //when
        final List<StationDto> actualResult = stationService.getClosestStation("LIRF", 0.0);

        //then
        Assertions.assertEquals(expectedResult,actualResult,"Airports returned !!");
    }

}