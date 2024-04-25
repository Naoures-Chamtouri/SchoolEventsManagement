package project.example.teacher.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.example.teacher.model.School;
import project.example.teacher.response.eventsResponse;
import project.example.teacher.service.teacherService;

@RestController
@RequestMapping("/api/teachers")
@RequiredArgsConstructor
public class teacherController {
    private final teacherService service;

    @GetMapping("/events")
    public ResponseEntity<eventsResponse> getAllEvents(){
        return ResponseEntity.ok(service.getEvents());
    }

    @GetMapping("/events/{id}")
    public ResponseEntity<School> getEventsperSchool(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.getSchoolEvents(id));
    }


}
