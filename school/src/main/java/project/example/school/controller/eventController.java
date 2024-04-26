package project.example.school.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.example.school.dto.eventDTO;
import project.example.school.model.Event;
import project.example.school.model.School;
import project.example.school.service.eventService;
import project.example.school.service.schoolService;

import java.util.List;

@RestController
@RequestMapping("/api/schools/events")
@RequiredArgsConstructor
public class eventController {

    private  final eventService service;
    private final schoolService Sservice;


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void saveByschool(@RequestBody Event event){
        service.saveEvent(event);

    }


    @PostMapping("/{manager}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> save(@PathVariable("manager") String manager,@RequestBody eventDTO eventdto){
        School school=Sservice.findSchool(eventdto.getSchoolId());
        Event event=Event.builder().eventName(eventdto.getEventName()).eventDescription(eventdto.getEventDescription()).eventDate(eventdto.getEventDate()).school(school).build();
        return ResponseEntity.ok(service.saveEvent(event));


    }

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<List<Event>> getAll(){
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<Event> getEvent(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.findEvent(id));
    }



}
