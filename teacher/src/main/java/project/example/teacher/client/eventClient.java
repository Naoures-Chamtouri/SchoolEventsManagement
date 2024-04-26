package project.example.teacher.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import project.example.teacher.dto.eventDTO;
import project.example.teacher.model.Event;
import project.example.teacher.model.School;

import java.util.List;

@FeignClient(name = "school", url = "${application.config.school-url}")
public interface eventClient {
    @GetMapping
    List<School> findAll();

    @GetMapping("/{id}")
    School findSchool(@PathVariable("id") Integer id);


    @PostMapping("/events/{manager}")
    String saveEvent(@PathVariable("manager") String manager, @RequestBody eventDTO event);
}
