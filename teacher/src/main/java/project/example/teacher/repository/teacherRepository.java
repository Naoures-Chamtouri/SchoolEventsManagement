package project.example.teacher.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.example.teacher.model.Teacher;

public interface teacherRepository extends JpaRepository<Teacher,Integer> {
}
