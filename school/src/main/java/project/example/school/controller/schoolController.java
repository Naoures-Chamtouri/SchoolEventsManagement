package project.example.school.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.example.school.consumer.schoolConsumer;
import project.example.school.model.Event;
import project.example.school.model.School;
import project.example.school.producer.schoolProducer;
import project.example.school.service.schoolService;

import java.util.List;

@RestController
@RequestMapping("/api/schools")
@RequiredArgsConstructor
public class schoolController {

    private final schoolService service;
    private  final schoolProducer producer;
    private  final schoolConsumer consumer;

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
    public ResponseEntity<School> getSchool(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.findSchool(id));
    }

    @PostMapping("/response")
    public ResponseEntity<String> sendResponse(@RequestBody String resp)
    {
    String msg ="Request Adding event "+resp;

        if (resp.equals("accepted")){
            Integer schoolId=consumer.getSchoolReq();
            String Res=msg+".key: : "+service.findKey(schoolId);
            producer.sendResponse(Res);
            return ResponseEntity.ok("Response sent succesfully");


    }else if(resp.equals("denied")){

            producer.sendResponse(msg);
            return ResponseEntity.ok("Response sent succesfully");
        }

        else{
            return ResponseEntity.ok("Enter a valid response");

        }


    }




}
