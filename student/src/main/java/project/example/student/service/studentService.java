package project.example.student.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.w3c.dom.events.Event;
import project.example.student.model.Student;
import project.example.student.model.studentEvent;
import project.example.student.repository.studentRepository;


@Service
@AllArgsConstructor
public class studentService {


    private final studentRepository repository;


    public void save(Student student){
        repository.save(student);
    }

    public void subscribe(Integer studentId, Event event) {

        studentEvent studentEvent = new studentEvent();
        studentEvent.setStudentId(studentId);
//        studentEvent.setEvent();
//        studentEventRepository.save(studentEvent);
    }

}
