package project.example.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.example.student.model.Student;


public interface studentRepository extends JpaRepository<Student,Integer> {
}
