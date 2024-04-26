package project.example.teacher.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import project.example.teacher.client.eventClient;
import project.example.teacher.dto.eventDTO;
import project.example.teacher.dto.teacherDto;
import project.example.teacher.model.Event;
import project.example.teacher.model.School;
import project.example.teacher.model.Teacher;
import project.example.teacher.repository.teacherRepository;
import project.example.teacher.response.eventsResponse;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor

public class teacherService {

    private final teacherRepository repository;
    private final  eventClient eventclient;


    public void save(Teacher teacher){
        repository.save(teacher);
    }



    public List<Teacher> getAll(){

        return repository.findAll();
    }
    public eventsResponse getEvents(){
        var events=eventclient.findAll();
        List<School> schoolsWithEvents = events.stream()
                .filter(school -> !school.getEvents().isEmpty())
                .collect(Collectors.toList());


        return eventsResponse.builder().Events(schoolsWithEvents).build();


    }
    public School getSchoolEvents(Integer id){
        var events=eventclient.findSchool(id);
        return events;

    }
    public String stringTeacher(Integer teacherId){
        var teacher=repository.findById(teacherId).orElse(null);
        var teacherDTO=new teacherDto(teacher.getTeacherId(),teacher.getFirstName(),teacher.getLastName(),teacher.getSchoolId());
        return teacherDTO.toString();

    }

    public void addEvent(String manager, eventDTO event){
        eventclient.saveEvent(manager,event);


    }


}
