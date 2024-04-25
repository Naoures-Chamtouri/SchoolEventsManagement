package project.example.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.example.student.model.studentEvent;

public interface stdenteventRepository extends JpaRepository<studentEvent,Integer> {
}
