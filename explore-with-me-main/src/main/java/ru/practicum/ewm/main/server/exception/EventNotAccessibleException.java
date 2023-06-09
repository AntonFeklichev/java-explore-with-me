package ru.practicum.ewm.main.server.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.CONFLICT;

@ResponseStatus(CONFLICT)
public class EventNotAccessibleException extends NotAccessibleException {
    public EventNotAccessibleException(String message) {
        super(message);
    }
}
