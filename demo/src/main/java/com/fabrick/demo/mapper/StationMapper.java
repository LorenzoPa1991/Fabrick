package com.fabrick.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.fabrick.demo.dto.StationDto;
import com.fabrick.demo.entity.Station;

@Mapper(componentModel = "spring")
public interface StationMapper {

    Station dtoToEntity(StationDto dto);

    StationDto entityToDto(Station entity);

    List<Station> listDtoToListEntity(List<StationDto> dtoList);

    List<StationDto> listEntityToListDto(List<Station> entityList);

}