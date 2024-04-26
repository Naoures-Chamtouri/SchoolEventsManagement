package project.example.teacher.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.example.teacher.model.Event;
import project.example.teacher.model.School;
import project.example.teacher.producer.teacherProducer;
import project.example.teacher.response.eventsResponse;
import project.example.teacher.service.teacherService;

@RestController
@RequestMapping("/api/teachers")
@RequiredArgsConstructor
public class teacherController {
    private final teacherService service;
    private final teacherProducer producer;

    @GetMapping("/events")
    public ResponseEntity<eventsResponse> getAllEvents(){
        return ResponseEntity.ok(service.getEvents());
    }

    @GetMapping("/events/{id}")
    public ResponseEntity<School> getEventsperSchool(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.getSchoolEvents(id));
    }

    @PostMapping("/addEvent")
    public ResponseEntity<String> sendEvent(@RequestBody EventDTO event){
        producer.sendMessage(event);
        return ResponseEntity.ok("Event sent Succesfully");

    }


}
