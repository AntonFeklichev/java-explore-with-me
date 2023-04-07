package ru.practicum.ewm.stats.endpointhit.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.practicum.ewm.stats.dto.CreateEndPointHitDto;
import ru.practicum.ewm.stats.endpointhit.service.EndpointHitService;

@RestController
@RequestMapping("/hit")
public class EndpointHitController {
    private final EndpointHitService endpointHitService;

    public EndpointHitController(EndpointHitService endpointHitService) {
        this.endpointHitService = endpointHitService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createEndpointHit(
            @RequestBody
            CreateEndPointHitDto createEndPointHitDto
    ) {

        endpointHitService.createEndpointHit(createEndPointHitDto);
    }
}
