package project.example.teacher.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.example.teacher.dto.eventDTO;
import project.example.teacher.model.Event;
import project.example.teacher.model.School;
import project.example.teacher.model.Teacher;
import project.example.teacher.producer.teacherProducer;
import project.example.teacher.response.eventsResponse;
import project.example.teacher.service.teacherService;

@RestController
@RequestMapping("/api/teachers")
@RequiredArgsConstructor
public class teacherController {
    private final teacherService service;
    private final teacherProducer producer;



     @PostMapping
     public void addTeacher(@RequestBody Teacher teacher){
         service.save(teacher);
     }

    @GetMapping("/events")
    public ResponseEntity<eventsResponse> getAllEvents(){
        return ResponseEntity.ok(service.getEvents());
    }

    @GetMapping("/events/{id}")
    public ResponseEntity<School> getEventsperSchool(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.getSchoolEvents(id));
    }


    @PostMapping("/request/{id}")
    public ResponseEntity<String> sendRequest(@PathVariable("id") Integer teacherId,@RequestBody String msg){
             var teacher=service.stringTeacher(teacherId);
             String req="teacher("+teacher+"sent request:"+msg;
             producer.sendMessage(req);
          return ResponseEntity.ok("Request sent succesfully ");
        }
    @PostMapping("/addEvent/{manager}")
    public ResponseEntity<String> sendEvent(@PathVariable("manager") String manager,@RequestBody eventDTO event){

         System.out.println(event.toString());
        service.addEvent(manager,event);
        return ResponseEntity.ok("Event sent Succesfully");

    }


}
