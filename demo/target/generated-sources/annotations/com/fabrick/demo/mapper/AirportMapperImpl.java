package com.fabrick.demo.mapper;

import com.fabrick.demo.dto.AirportDto;
import com.fabrick.demo.entity.Airport;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-04T22:35:43+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class AirportMapperImpl implements AirportMapper {

    @Override
    public Airport dtoToEntity(AirportDto dto) {
        if ( dto == null ) {
            return null;
        }

        Airport airport = new Airport();

        airport.setId( dto.getId() );
        airport.setIata( dto.getIata() );
        airport.setName( dto.getName() );
        airport.setCountry( dto.getCountry() );
        airport.setState( dto.getState() );
        airport.setLatitude( dto.getLatitude() );
        airport.setLongitude( dto.getLongitude() );
        airport.setElevation( dto.getElevation() );

        return airport;
    }

    @Override
    public AirportDto entityToDto(Airport entity) {
        if ( entity == null ) {
            return null;
        }

        AirportDto airportDto = new AirportDto();

        airportDto.setId( entity.getId() );
        airportDto.setIata( entity.getIata() );
        airportDto.setName( entity.getName() );
        airportDto.setCountry( entity.getCountry() );
        airportDto.setState( entity.getState() );
        airportDto.setLatitude( entity.getLatitude() );
        airportDto.setLongitude( entity.getLongitude() );
        airportDto.setElevation( entity.getElevation() );

        return airportDto;
    }

    @Override
    public List<Airport> listDtoToListEntity(List<AirportDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Airport> list = new ArrayList<Airport>( dtoList.size() );
        for ( AirportDto airportDto : dtoList ) {
            list.add( dtoToEntity( airportDto ) );
        }

        return list;
    }

    @Override
    public List<AirportDto> listEntityToListDto(List<Airport> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<AirportDto> list = new ArrayList<AirportDto>( entityList.size() );
        for ( Airport airport : entityList ) {
            list.add( entityToDto( airport ) );
        }

        return list;
    }
}
