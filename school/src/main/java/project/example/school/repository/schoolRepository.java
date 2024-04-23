package project.example.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.example.school.model.School;

public interface schoolRepository  extends JpaRepository<School,Integer> {

}

