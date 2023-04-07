package ru.practicum.endpointhit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EndpointHitRepository extends JpaRepository<EndpointHitRepository, Long> {

}
