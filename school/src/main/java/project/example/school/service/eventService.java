package project.example.school.service;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import project.example.school.model.Event;
import project.example.school.model.School;
import project.example.school.repository.eventRepository;

import java.util.List;


@Service
@AllArgsConstructor
public class eventService {

    private final eventRepository repository;


    public void saveEvent(Event event) {
        repository.save(event);
    }

    public Event findEvent(Integer id){
        var event= repository.findById(id).orElse(
                Event.builder()
                        .eventName("NOT_FOUND")
                        .eventDate(null).eventDescription("Not_FOUND")
                        .build()
        );
        return event;
    }

    public List<Event> findAll(){
        return repository.findAll();
    }


}


