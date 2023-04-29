package ru.practicum.ewm.main.server.event.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.ewm.main.server.event.service.EventService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "/admin/events")
@RequiredArgsConstructor
public class AdminEventController {
    private final EventService eventService;

    @GetMapping
    public List<AdminEventDto> getEvents(
            @RequestParam(
                    name = "users",
                    defaultValue = ""
            )
            List<Long> userIds,
            @RequestParam(
                    name = "states",
                    defaultValue = ""
            )
            List<String> states,
            @RequestParam(
                    name = "categories",
                    defaultValue = ""
            )
            List<Long> categoryIds,
            @RequestParam(
                    name = "rangeStart",
                    required = false
            )
            LocalDateTime rangeStart,
            @RequestParam(
                    name = "rangeEnd",
                    required = false
            )
            LocalDateTime rangeEnd,
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
        return eventService.getEvents(
                userIds,
                states,
                categoryIds,
                rangeStart,
                rangeEnd,
                from,
                size);
    }


}