package ru.practicum.ewm.main.server.event.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.practicum.ewm.main.server.event.dto.CreateEventRequestDto;
import ru.practicum.ewm.main.server.event.dto.EventFullDto;
import ru.practicum.ewm.main.server.event.dto.UpdateEventRequestDto;
import ru.practicum.ewm.main.server.event.service.EventService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{userId}/events")
    public EventFullDto createEvent(
            @PathVariable(name = "userId")
            Long userId,
            @Valid
            @RequestBody
            CreateEventRequestDto eventDto
    ) {
        return eventService.createEvent(userId, eventDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{userId}/events")
    public List<EventShortDto> getEventsByUserId(
            @PathVariable(name = "userId")
            Long userId,
            @RequestParam(
                    name = "from",
                    defaultValue = "0"
            )
            Integer from,
            @RequestParam(
                    name = "size",
                    defaultValue = "10"
            )
            Integer size
    ) {
        return eventService.getEventsByUserId(
                userId,
                from,
                size
        );
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{userId}/events/{eventId}")
    public EventFullDto getEventByUserIdAndEventId(
            @PathVariable(name = "userId")
            Long userId,
            @PathVariable(name = "eventId")
            Long eventId
    ) {
        return eventService.getEventByUserIdAndEventId(userId, eventId);
    }

    @PatchMapping("/{userId}/events/{eventId}")
    public EventFullDto patchEvent(
            @PathVariable(name = "eventId")
            Long eventId,
            @PathVariable(name = "userId")
            Long userId,
            @Valid
            @RequestBody
            UpdateEventRequestDto updateDto
    ) {
        return eventService.patchEvent(
                eventId,
                userId,
                updateDto
        );
    }

}
