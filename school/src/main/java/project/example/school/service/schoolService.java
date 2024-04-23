package project.example.school.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import project.example.school.model.Event;
import project.example.school.model.School;
import project.example.school.repository.schoolRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class schoolService {
    private final schoolRepository repository;


    public void saveSchool(School school) {
        repository.save(school);
    }

    public School findSchool(int id){
       var school= repository.findById(id).orElse(
                School.builder()
                        .schoolName("NOT_FOUND")
                        .schoolLocation("NOT_FOUND")
                        .build()
        );
        return school;
    }

    public List<School> findAll(){
        return repository.findAll();
    }





}
