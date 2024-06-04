package com.fabrick.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.fabrick.demo.dto.AirportDto;
import com.fabrick.demo.entity.Airport;

@Mapper(componentModel = "spring")
public interface AirportMapper {

    Airport dtoToEntity(AirportDto dto);

    AirportDto entityToDto(Airport entity);

    List<Airport> listDtoToListEntity(List<AirportDto> dtoList);

    List<AirportDto> listEntityToListDto(List<Airport> entityList);

}

