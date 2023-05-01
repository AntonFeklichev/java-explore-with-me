package ru.practicum.ewm.main.server.participationrequest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.ewm.main.server.event.entity.Event;
import ru.practicum.ewm.main.server.event.repository.CustomEventRepository;
import ru.practicum.ewm.main.server.event.state.State;
import ru.practicum.ewm.main.server.exception.*;
import ru.practicum.ewm.main.server.participationrequest.entity.ParticipationRequest;
import ru.practicum.ewm.main.server.participationrequest.entity.ParticipationRequestDto;
import ru.practicum.ewm.main.server.participationrequest.entity.ParticipationRequestMapper;
import ru.practicum.ewm.main.server.participationrequest.repository.ParticipationRequestRepository;
import ru.practicum.ewm.main.server.user.entity.User;
import ru.practicum.ewm.main.server.user.repository.UserRepository;

import java.util.List;
import java.util.Objects;

import static java.time.LocalDateTime.now;
import static java.util.stream.Collectors.toList;
import static ru.practicum.ewm.main.server.participationrequest.dto.ParticipationRequestStatus.*;

@Service
@RequiredArgsConstructor
public class ParticipationRequestService {
    private final ParticipationRequestRepository participationRequestRepository;
    private final UserRepository userRepository;
    private final CustomEventRepository eventRepository;
    private final ParticipationRequestMapper participationRequestMapper;

    public ParticipationRequestDto createParticipationRequest(Long userId, Long eventId) {
        User requester = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("Could not find the requested user."));
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new EventNotFoundException("Could not find the requested event."));
        if (Objects.equals(event.getConfirmedRequests(), event.getParticipantLimit())) {
            throw new ParticipantLimitReachedException("Reached participant limit of the event.");
        }
        checkIfRequesterIsNotInitiatorOfEvent(userId, event);
        checkIfEventIsPublished(event);
        ParticipationRequest request = ParticipationRequest
                .builder()
                .status(event.isRequestModerated() ? PENDING : CONFIRMED)
                .event(event)
                .requester(requester)
                .created(now())
                .build();
        ParticipationRequest saved = participationRequestRepository.save(request);
        return participationRequestMapper.toDto(saved);
    }

    public List<ParticipationRequestDto> getParticipationRequestsByParticipatorId(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new UserNotFoundException("Could not find the requested user.");
        }
        return userRepository
                .findAllByRequesterId(userId).stream()
                .map(participationRequestMapper::toDto)
                .collect(toList());
    }

    public ParticipationRequestDto cancelParticipationRequest(Long userId, Long requestId) {
        return participationRequestRepository.findById(requestId)
                .map(
                        request -> {
                            if (!Objects.equals(request.getRequester().getId(), userId)) {
                                throw new EventNotAccessibleException("You can not cancel requests of other users.");
                            }
                            request.setStatus(CANCELED);
                            ParticipationRequest saved = participationRequestRepository.save(request);
                            return participationRequestMapper.toDto(saved);
                        }
                )
                .orElseThrow(
                        () -> new ParticipationRequestNotFoundException("Could not find the requested participation request.")
                );
    }

    private void checkIfEventIsPublished(Event event) {
        if (event.getState() != State.PUBLISHED) {
            throw new EventNotPublishedException("You cannot request participation in event that is not published yet.");
        }
    }

    private void checkIfRequesterIsNotInitiatorOfEvent(Long userId, Event event) {
        if (Objects.equals(event.getInitiator().getId(), userId)) {
            throw new InitiatorParticipationRequestException("You cannot request participation in the event if you are its initiator");
        }
    }
}