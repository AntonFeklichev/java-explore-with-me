package ru.practicum.ewm.stats.endpointhit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.practicum.ewm.stats.endpointhit.entity.EndpointHit;

@Repository
public interface EndpointHitRepository extends JpaRepository<EndpointHit, Long> {
}
