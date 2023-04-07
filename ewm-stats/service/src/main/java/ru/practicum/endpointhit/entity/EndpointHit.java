package ru.practicum.endpointhit.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class EndpointHit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "endpoint_hit_id")
    Long id;
    @Column(name = "app_name")
    String app;

    @Column(name = "endpoint_hit_uri")
    String uri;

    @Column(name = "endpoint_hit_timestamp")
    LocalDateTime timestamp;
}
