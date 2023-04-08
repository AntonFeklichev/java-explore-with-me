package ru.practicum.ewm.stats.endpointhit.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.practicum.ewm.stats.dto.endpointhit.CreateEndPointHitDto;
import ru.practicum.ewm.stats.endpointhit.service.EndpointHitService;

@RestController
@RequestMapping("/hit")
@RequiredArgsConstructor
public class EndpointHitController {
    private final EndpointHitService endpointHitService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createEndpointHit(
            @RequestBody
            CreateEndPointHitDto createEndPointHitDto
    ) {

        endpointHitService.createEndpointHit(createEndPointHitDto);
    }
}
