package project.example.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.example.school.model.Event;

public interface eventRepository extends JpaRepository<Event,Integer> {

}
