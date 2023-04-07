package ru.practicum.ewm.stats.endpointhit.service;

import org.springframework.stereotype.Service;
import ru.practicum.ewm.stats.dto.CreateEndPointHitDto;
import ru.practicum.ewm.stats.endpointhit.entity.EndpointHit;
import ru.practicum.ewm.stats.endpointhit.mapper.CreateEndPointHitMapper;
import ru.practicum.ewm.stats.endpointhit.repository.EndpointHitRepository;

@Service
public class EndpointHitService {
    private final EndpointHitRepository endpointHitRepository;

    public EndpointHitService(EndpointHitRepository endpointHitRepository) {
        this.endpointHitRepository = endpointHitRepository;
    }

    public void createEndpointHit(CreateEndPointHitDto createEndPointHitDto) {
        EndpointHit hit = CreateEndPointHitMapper.INSTANCE.toEntity(createEndPointHitDto);
        endpointHitRepository.save(hit);
    }
}
