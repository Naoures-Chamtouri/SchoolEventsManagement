package project.example.teacher.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import project.example.teacher.model.School;

import java.util.List;

@FeignClient(name = "school", url = "${application.config.school-url}")
public interface eventClient {
    @GetMapping
    List<School> findAll();

    @GetMapping("/{id}")
    School findSchool(@PathVariable("id") Integer id);
}
