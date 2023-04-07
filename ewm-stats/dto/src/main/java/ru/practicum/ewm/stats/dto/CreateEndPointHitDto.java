package ru.practicum.ewm.stats.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Builder
public class CreateEndPointHitDto {
    @NotBlank(message = "App name cannot be blank or null.")
    private String app;

    @NotBlank(message = "Endpoint hit uri cannot be blank or null.")
    private String uri;

    @NotBlank(message = "Requester ip address cannot be blank or null.")
    private String ip;

    @NotNull(message = "Endpoint hit timestamp cannot be null.")
    private LocalDateTime timestamp;
}
