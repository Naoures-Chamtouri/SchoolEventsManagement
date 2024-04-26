package project.example.student.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.w3c.dom.events.Event;
import project.example.student.client.eventClient;
import project.example.student.model.School;
import project.example.student.model.Student;
import project.example.student.model.studentEvent;
import project.example.student.repository.studentRepository;
import project.example.student.response.eventResponse;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class studentService {


    private final studentRepository repository;
    private final eventClient eventclient;


    public void save(Student student){
        repository.save(student);
    }





//    public void subscribe(Integer studentId, Event event) {
//
//        studentEvent studentEvent = new studentEvent();
//        studentEvent.(studentId);
////        studentEvent.setEvent();
////        studentEventRepository.save(studentEvent);
//    }


    public List<Student> getAll(){

        return repository.findAll();
    }
    public eventResponse getEvents(){

        var events=eventclient.findAll();
        List<School> schoolsWithEvents = events.stream()
                .filter(school -> !school.getEvents().isEmpty())
                .collect(Collectors.toList());


        return eventResponse.builder().Events(schoolsWithEvents).build();


    }
    public School getSchoolEvents(Integer id){
        var events=eventclient.findSchool(id);
        return events;

    }

}
