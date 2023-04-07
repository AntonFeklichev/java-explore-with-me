package ru.practicum.ewm.stats.endpointhit.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.practicum.ewm.stats.dto.CreateEndPointHitDto;
import ru.practicum.ewm.stats.endpointhit.entity.EndpointHit;

@Mapper
public interface CreateEndPointHitMapper {
    CreateEndPointHitMapper INSTANCE = Mappers.getMapper(CreateEndPointHitMapper.class);

    EndpointHit toEntity(CreateEndPointHitDto dto);

}
