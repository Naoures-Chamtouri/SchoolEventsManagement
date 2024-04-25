package project.example.school.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.example.school.model.Event;
import project.example.school.service.eventService;

import java.util.List;

@RestController
@RequestMapping("/api/schools/events")
@RequiredArgsConstructor
public class eventController {

    private  final eventService service;


    @PostMapping("/{manager}")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Event event){
        service.saveEvent(event);

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
