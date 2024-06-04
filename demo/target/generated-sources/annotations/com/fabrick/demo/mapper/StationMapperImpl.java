package com.fabrick.demo.mapper;

import com.fabrick.demo.dto.StationDto;
import com.fabrick.demo.entity.Station;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-04T22:35:44+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class StationMapperImpl implements StationMapper {

    @Override
    public Station dtoToEntity(StationDto dto) {
        if ( dto == null ) {
            return null;
        }

        Station station = new Station();

        station.setId( dto.getId() );
        station.setName( dto.getName() );
        station.setCountry( dto.getCountry() );
        station.setState( dto.getState() );
        station.setLatitude( dto.getLatitude() );
        station.setLongitude( dto.getLongitude() );
        station.setElevation( dto.getElevation() );

        return station;
    }

    @Override
    public StationDto entityToDto(Station entity) {
        if ( entity == null ) {
            return null;
        }

        StationDto stationDto = new StationDto();

        stationDto.setId( entity.getId() );
        stationDto.setName( entity.getName() );
        stationDto.setCountry( entity.getCountry() );
        stationDto.setState( entity.getState() );
        stationDto.setLatitude( entity.getLatitude() );
        stationDto.setLongitude( entity.getLongitude() );
        stationDto.setElevation( entity.getElevation() );

        return stationDto;
    }

    @Override
    public List<Station> listDtoToListEntity(List<StationDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Station> list = new ArrayList<Station>( dtoList.size() );
        for ( StationDto stationDto : dtoList ) {
            list.add( dtoToEntity( stationDto ) );
        }

        return list;
    }

    @Override
    public List<StationDto> listEntityToListDto(List<Station> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<StationDto> list = new ArrayList<StationDto>( entityList.size() );
        for ( Station station : entityList ) {
            list.add( entityToDto( station ) );
        }

        return list;
    }
}
