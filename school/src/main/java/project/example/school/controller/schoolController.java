package project.example.school.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.example.school.model.Event;
import project.example.school.model.School;
import project.example.school.service.schoolService;

import java.util.List;

@RestController
@RequestMapping("/api/schools")
@RequiredArgsConstructor
public class schoolController {

    private final schoolService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(
            @RequestBody School school) {
        service.saveSchool(school);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<List<School>> getAll(){
        return ResponseEntity.ok(service.findAll());
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<School> getSchool(@PathVariable("id") int id){
        return ResponseEntity.ok(service.findSchool(id));
    }




}
