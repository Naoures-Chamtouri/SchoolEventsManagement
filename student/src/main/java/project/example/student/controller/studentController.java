package project.example.student.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.example.student.model.School;
import project.example.student.model.Student;
import project.example.student.response.eventResponse;
import project.example.student.service.studentService;

@RestController
@RequiredArgsConstructor
public class studentController {

    private final studentService service;
    @PostMapping
    public void addTeacher(@RequestBody Student student){
        service.save(student);
    }

    @GetMapping("/events")
    public ResponseEntity<eventResponse> getAllEvents(){
        return ResponseEntity.ok(service.getEvents());
    }

    @GetMapping("/events/{id}")
    public ResponseEntity<School> getEventsperSchool(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.getSchoolEvents(id));
    }
}

