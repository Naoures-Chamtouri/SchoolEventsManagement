package project.example.teacher.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Teacher {
    @Id
    @GeneratedValue
    private Integer teacherId;
    private String firstName;
    private String lastName;
    private Integer schoolId;
    @OneToMany(mappedBy="teacher",
            cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<teacherEvent> events;


}
