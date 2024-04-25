package project.example.teacher.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.example.teacher.model.teacherEvent;

public interface teachereventRepository extends JpaRepository<teacherEvent,Integer> {
}
